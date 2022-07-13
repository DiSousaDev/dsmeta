package br.dev.diego.dsmeta.controllers;

import br.dev.diego.dsmeta.controllers.dto.SaleRespondeDto;
import br.dev.diego.dsmeta.services.SaleService;
import br.dev.diego.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public ResponseEntity<Page<SaleRespondeDto>> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return ResponseEntity.ok(service.findSales(minDate, maxDate, pageable));
    }

    @GetMapping("/{id}/notification")
    public ResponseEntity<Void> notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
        return ResponseEntity.noContent().build();
    }

}
