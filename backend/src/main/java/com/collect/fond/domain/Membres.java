package com.collect.fond.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
@Table(name = "membres")
public class Membres extends AbstractEntity{

    @Id
    @SequenceGenerator(name = "membres_id_seq", sequenceName = "membres_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membres_id_seq")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String prenoms;

    @Column(nullable = false, unique = true, length = 20)
    private String telephone;

    @Column(length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String formule;

    @Column(name = "date_inscription")
    private LocalDateTime dateInscription = LocalDateTime.now();

    public Membres() {}

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getFormule() {
        return formule;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNom(String nom) {this.nom = nom;}

    public void setPrenoms(String prenoms) {this.prenoms = prenoms;}

    public void setTelephone(String telephone) {this.telephone = telephone;}

    public void setEmail(String email) {this.email = email;}

    public void setFormule(String formule) {this.formule = formule;}

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }

}