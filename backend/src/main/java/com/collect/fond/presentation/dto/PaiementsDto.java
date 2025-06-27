package com.collect.fond.presentation.dto;

import com.collect.fond.domain.Membres;

import java.time.LocalDateTime;

public class PaiementsDto {
    private Long id;
    private Membres membres;
    private LocalDateTime datePaiement;
    private Long montant;
    private String info;


    public PaiementsDto() {}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Membres getMembres() { return membres; }
    public void setMembres(Membres membres) { this.membres = membres; }

    public LocalDateTime getDatePaiement() { return datePaiement; }
    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Long getMontant() { return montant; }
    public void setMontant(Long montant) { this.montant = montant; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }
}
