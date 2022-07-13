package br.dev.diego.dsmeta.services;

import br.dev.diego.dsmeta.controllers.dto.SaleRespondeDto;
import br.dev.diego.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;
    @Transactional
    public List<SaleRespondeDto> findAll() {
        return repository.findAll().stream().map(SaleRespondeDto::new).collect(Collectors.toList());
    }
}
