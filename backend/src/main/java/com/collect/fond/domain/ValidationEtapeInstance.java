package com.collect.fond.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
@Table(name = ValidationEtapeInstance.TABLE_NAME)
public class ValidationEtapeInstance extends AbstractEntity {

    public static final String TABLE_NAME = "validation_etape_instance";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = "validation_etape_instance_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "id_demande", nullable = false)
    private Long idDemande;

    @Column(name = "id_config", nullable = false)
    private Long idConfig;

    @Column(name = "type_demande", length = 50, nullable = false)
    private String typeDemande;

    @Column(name = "numero_etape", nullable = false)
    private Integer numeroEtape;

    @Column(name = "nom_etape", length = 255, nullable = false)
    private String nomEtape;

    @Column(name = "statut", length = 50, nullable = false)
    private String statut = "NON_DEMARRE";

    @Column(name = "commentaire", length = 255, nullable = false)
    private String commentaire;

    @Column(name = "id_utilisateur_validation", nullable = false)
    private Long idUtilisateurValidation;

    @Column(name = "username_validation", length = 50, nullable = false)
    private String usernameValidation;

    @Column(name = "nom_prenom_validation", length = 50, nullable = false)
    private String nomPrenomValidation;

    @Column(name = "evenement_succes", length = 50, nullable = false)
    private String evenementSucces;

    @Column(name = "date_debut")
    private LocalDateTime dateDebut;

    @Column(name = "valeur_extra", length = 255, nullable = false)
    private String valeurExtra;

    @Column(name = "date_fin")
    private LocalDateTime dateFin;

    @Column(name = "delai_jours")
    private Integer delaiJours;

    @Column(name = "date_prevision")
    private LocalDateTime datePrevision;

    public ValidationEtapeInstance() {
    }

    public ValidationEtapeInstance(Long idDemande, Long idConfig, String typeDemande, Integer numeroEtape, String nomEtape, String statut, String commentaire, Long idUtilisateurValidation, String usernameValidation, String nomPrenomValidation, String evenementSucces, LocalDateTime dateDebut, String valeurExtra, LocalDateTime dateFin, Integer delaiJours, LocalDateTime datePrevision) {
        this.idDemande = idDemande;
        this.idConfig = idConfig;
        this.typeDemande = typeDemande;
        this.numeroEtape = numeroEtape;
        this.nomEtape = nomEtape;
        this.statut = statut;
        this.commentaire = commentaire;
        this.idUtilisateurValidation = idUtilisateurValidation;
        this.usernameValidation = usernameValidation;
        this.nomPrenomValidation = nomPrenomValidation;
        this.evenementSucces = evenementSucces;
        this.dateDebut = dateDebut;
        this.valeurExtra = valeurExtra;
        this.dateFin = dateFin;
        this.delaiJours = delaiJours;
        this.datePrevision = datePrevision;
    }

    public Long getId() { return id; }

    public Long getIdDemande() {
        return idDemande;
    }

    public Long getIdConfig() {
        return idConfig;
    }

    public String getTypeDemande() {
        return typeDemande;
    }

    public Integer getNumeroEtape() {
        return numeroEtape;
    }

    public String getNomEtape() {
        return nomEtape;
    }

    public String getStatut() {
        return statut;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Long getIdUtilisateurValidation() {
        return idUtilisateurValidation;
    }

    public String getUsernameValidation() {
        return usernameValidation;
    }

    public String getNomPrenomValidation() {
        return nomPrenomValidation;
    }

    public String getEvenementSucces() {
        return evenementSucces;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public String getValeurExtra() {
        return valeurExtra;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public Integer getDelaiJours() {
        return delaiJours;
    }

    public LocalDateTime getDatePrevision() {
        return datePrevision;
    }
}