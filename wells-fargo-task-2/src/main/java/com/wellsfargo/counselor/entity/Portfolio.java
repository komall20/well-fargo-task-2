package com.wellsfargo.counselor.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue
    private long portfolioId;

    @Column(nullable = false)
    private Integer clientId;

    @Column(nullable = false)
    private LocalDate creationDate;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    @ManyToOne
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private Client client;

    protected Portfolio() {

    }

    public Portfolio(long portfolioId, Integer clientId, LocalDateTime creationDate, List<Security> securities) {
        this.portfolioId = portfolioId;
        this.clientId = clientId;
        this.creationDate = LocalDate.from(creationDate);
        this.securities = securities;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = LocalDate.from(creationDate);
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
