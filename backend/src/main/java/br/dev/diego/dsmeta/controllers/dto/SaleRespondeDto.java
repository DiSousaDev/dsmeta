package br.dev.diego.dsmeta.controllers.dto;

import br.dev.diego.dsmeta.entities.Sale;

import java.time.LocalDate;

public class SaleRespondeDto {

    private Long id;
    private String sellerName;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;

    public SaleRespondeDto() {
    }

    public SaleRespondeDto(Long id, String sellerName, Integer visited, Integer deals, LocalDate date) {
        this.id = id;
        this.sellerName = sellerName;
        this.visited = visited;
        this.deals = deals;
        this.date = date;
    }

    public SaleRespondeDto(Sale entity) {
        id = entity.getId();
        sellerName = entity.getSellerName();
        visited = entity.getVisited();
        deals = entity.getDeals();
        date = entity.getDate();
    }

    public Long getId() {
        return id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Integer getVisited() {
        return visited;
    }

    public Integer getDeals() {
        return deals;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

}
