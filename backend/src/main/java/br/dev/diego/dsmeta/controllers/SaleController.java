package br.dev.diego.dsmeta.controllers;

import br.dev.diego.dsmeta.controllers.dto.SaleRespondeDto;
import br.dev.diego.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<List<SaleRespondeDto>> findALl() {
        return ResponseEntity.ok(service.findAll());
    }

}
