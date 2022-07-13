package br.dev.diego.dsmeta.services;

import br.dev.diego.dsmeta.controllers.dto.SaleRespondeDto;
import br.dev.diego.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;
    @Transactional
    public Page<SaleRespondeDto> findSales(String min, String max, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate minDate = min.equals("") ? today.minusDays(365) : LocalDate.parse(min);
        LocalDate maxDate = max.equals("") ? today : LocalDate.parse(max);

        return repository.findSales(minDate, maxDate, pageable).map(SaleRespondeDto::new);
    }

}
