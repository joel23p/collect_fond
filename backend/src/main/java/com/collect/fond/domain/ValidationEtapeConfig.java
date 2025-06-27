package com.collect.fond.domain;

import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = ValidationEtapeConfig.TABLE_NAME)
public class ValidationEtapeConfig extends AbstractEntity {

    public static final String TABLE_NAME = "validation_etape_config";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = "validation_etape_config_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "nom_etape", nullable = false, length = 255)
    private String nomEtape;

    @Column(name = "numero_etape", nullable = false)
    private Integer numeroEtape;

    @Column(name = "delai_jours", nullable = false)
    private Integer delaiJours;

    @Column(name = "type_demande", nullable = false, length = 50)
    private String typeDemande;

    @Column(name = "evenement_succes", nullable = false, length = 50)
    private String evenementSucces;

    public ValidationEtapeConfig() {
    }

    public ValidationEtapeConfig(Long id, String nomEtape, Integer numeroEtape, Integer delaiJours, String typeDemande, String evenementSucces) {
        this.id = id;
        this.nomEtape = nomEtape;
        this.numeroEtape = numeroEtape;
        this.delaiJours = delaiJours;
        this.typeDemande = typeDemande;
        this.evenementSucces = evenementSucces;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNomEtape() {
        return nomEtape;
    }

    public Integer getNumeroEtape() {
        return numeroEtape;
    }

    public Integer getDelaiJours() {
        return delaiJours;
    }

    public String getTypeDemande() {
        return typeDemande;
    }

    public String getEvenementSucces() {
        return evenementSucces;
    }
}