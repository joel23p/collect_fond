package com.collect.fond.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
@Table(name = "paiements")
public class Paiements extends AbstractEntity {

    @Id
    @SequenceGenerator(name = "paiements_id_seq", sequenceName = "paiements_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "paiements_id_seq")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "membres_id", nullable = false)
    private Membres membres;

    @Column(name = "date_paiement", nullable = false)
    private LocalDateTime datePaiement = LocalDateTime.now();

    @Column( name = "montant", nullable = false)
    private Long montant;

    @Column( name = "info")
    private String info;

    public Paiements() {}

    public Long getId() {
        return id;
    }

    public Membres getMembre() {
        return membres;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public Long getMontant() {
        return montant;
    }

    public String getNote() {
        return info;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMembre(Membres membres) { this.membres = membres; }

    public void setDatePaiement(LocalDateTime datePaiement) {this.datePaiement = datePaiement;}

    public void setMontant(Long montant) {this.montant = montant;}

    public void setInfo(String info) {this.info = info;}

}