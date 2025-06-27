package com.collect.fond.presentation.dto;

import com.collect.fond.domain.Marie;
import com.collect.fond.domain.Marie.TypeMarie;

import java.time.LocalDate;

public class MarieDto {

    private long id;
    private String nom;
    private String prenoms;
    private String telephone;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String profession;
    private String pere;
    private String mere;
    private String domicile;
    private TypeMarie type;

    public MarieDto() {
    }

    public MarieDto(Marie marie) {
        this.id = marie.getId();
        this.nom = marie.getNom();
        this.prenoms = marie.getPrenoms();
        this.telephone = marie.getTelephone();
        this.dateNaissance = marie.getDateNaissance();
        this.lieuNaissance = marie.getLieuNaissance();
        this.profession = marie.getProfession();
        this.pere = marie.getPere();
        this.mere = marie.getMere();
        this.domicile = marie.getDomicile();
        this.type = marie.getType();
    }

    public long getId() { return id; }
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

    @Override
    public String toString() {
        return "MarieDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenoms='" + prenoms + '\'' +
                ", telephone='" + telephone + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                ", profession='" + profession + '\'' +
                ", pere='" + pere + '\'' +
                ", mere='" + mere + '\'' +
                ", domicile='" + domicile + '\'' +
                ", type=" + type +
                '}';
    }
}