package com.collect.fond.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Access(AccessType.FIELD)
@Table(name = Marie.TABLE_NAME)
public class Marie extends AbstractEntity {

    public static final String TABLE_NAME = "marie";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = "marie_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    private String nom;
    private String prenoms;
    private String telephone;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String profession;
    private String pere;
    private String mere;
    private String domicile;

    @Enumerated(EnumType.STRING)
    private TypeMarie type;

    public enum TypeMarie {
        EPOUX, EPOUSE
    }

    public Marie() {
    }

    public Marie(String nom, String prenoms, String telephone, LocalDate dateNaissance, String lieuNaissance, String profession, String pere, String mere, String domicile, TypeMarie type) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.profession = profession;
        this.pere = pere;
        this.mere = mere;
        this.domicile = domicile;
        this.type = type;
    }

    public void mettreAJour(String nom, String prenoms, String telephone, LocalDate dateNaissance, String lieuNaissance, String profession, String pere, String mere, String domicile, TypeMarie type) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.profession = profession;
        this.pere = pere;
        this.mere = mere;
        this.domicile = domicile;
        this.type = type;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenoms() { return prenoms; }
    public String getTelephone() { return telephone; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getLieuNaissance() { return lieuNaissance; }
    public String getProfession() { return profession; }
    public String getPere() { return pere; }
    public String getMere() { return mere; }
    public String getDomicile() { return domicile; }
    public TypeMarie getType() { return type; }

    public void setType(TypeMarie type) { this.type = type; }
}