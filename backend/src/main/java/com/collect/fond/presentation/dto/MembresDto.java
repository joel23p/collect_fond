package com.collect.fond.presentation.dto;

import java.time.LocalDateTime;

public class MembresDto {
    private Long id;
    private String nom;
    private String prenoms;
    private String telephone;
    private String email;
    private String formule;
    private LocalDateTime dateInscription;

    public MembresDto() {}

    public MembresDto(String nom, String prenoms, String telephone, String email, String formule , LocalDateTime dateInscription) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.telephone = telephone;
        this.email = email;
        this.formule = formule;
        this.dateInscription = dateInscription;
    }



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenoms() { return prenoms; }
    public String setPrenoms(String prenoms) {this.prenoms = prenoms; return prenoms;}

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFormule() { return formule; }
    public void setFormule(String formule) { this.formule = formule; }

    public LocalDateTime getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDateTime dateInscription) { this.dateInscription = dateInscription; }
}
