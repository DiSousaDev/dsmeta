package br.dev.diego.dsmeta.services;

import br.dev.diego.dsmeta.entities.Sale;
import br.dev.diego.dsmeta.repositories.SaleRepository;
import br.dev.diego.dsmeta.services.exceptions.DataNotFoundException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class SmsService {

    private static final Logger LOG = LoggerFactory.getLogger(SmsService.class);
    @Autowired
    private SaleRepository saleRepository;

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    public void sendSms(Long id) {

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Sale sale = saleRepository.findById(id).orElseThrow(() ->
                new DataNotFoundException("Venda não encontrada"));
        String msg = "Data: " + brDate(sale.getDate()) +
                        "\nVendedor: " + sale.getSellerName() +
                        "\nValor: " + brValue(sale.getAmount());

        Message message = Message.creator(to, from, msg).create();
        LOG.info(">>>>Sending sms... >>> Message id: {}", message.getSid());
    }

    private String brDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private String brValue(Double value) {
        Locale ptBR = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(ptBR).format(value);
    }
}
