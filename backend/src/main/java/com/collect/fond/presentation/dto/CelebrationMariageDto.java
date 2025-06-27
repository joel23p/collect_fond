package com.collect.fond.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.collect.fond.domain.CelebrationMariage;
import com.collect.fond.domain.ValidationEtapeInstance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CelebrationMariageDto {

    private Long id;
    private Long idUtilisateurDemande;
    private String codeDemande;
    private String nomEpoux;
    private String prenomsEpoux;
    private String telephoneEpoux;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateNaissEpoux;
    private String lieuNaissEpoux;
    private String professionEpoux;
    private String nomPereEpoux;
    private String prenomsPereEpoux;
    private String nomMereEpoux;
    private String prenomsMereEpoux;
    private String domicileEpoux;
    private String typePieceIdentEpoux;
    private String chemPieceIdentEpoux;
    private String certifResidenceEpoux;
    private String nomTemoinEpoux;
    private String prenomsTemoinEpoux;
    private String professionTemoinEpoux;
    private String domicileTemoinEpoux;
    private String typePieceIdentTemoinEpoux;
    private String chemPieceIdentTemoinEpoux;
    private String photoIdentEpoux;
    private String situationMatriEpoux;
    private String nomEpouse;
    private String prenomsEpouse;
    private String telephoneEpouse;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateNaissEpouse;
    private String lieuNaissEpouse;
    private String professionEpouse;
    private String nomPereEpouse;
    private String prenomsPereEpouse;
    private String nomMereEpouse;
    private String prenomsMereEpouse;
    private String domicileEpouse;
    private String typePieceIdentEpouse;
    private String chemPieceIdentEpouse;
    private String certifResidenceEpouse;
    private String nomTemoinEpouse;
    private String prenomsTemoinEpouse;
    private String professionTemoinEpouse;
    private String domicileTemoinEpouse;
    private String typePieceIdentTemoinEpouse;
    private String chemPieceIdentTemoinEpouse;
    private String photoIdentEpouse;
    private String situationMatriEpouse;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime dateRendezVous;
    private String regime = "COMMUNAUTE_BIEN";
    private String statut = "NON_DEMARRE";
    private String roleDemandeur = "EPOUX";
    private Long montant;
    private Integer idEtapeActive;
    private Long delaiEtapeActive;
    private String nomEtapeActive;
    private String codeRegistre;
    private Long idRegistre;

    private List<ValidationEtapeInstance> etapes;

    public Long getId() {
        return id;
    }

    public Long getIdUtilisateurDemande() {
        return idUtilisateurDemande;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public String getNomEpoux() {
        return nomEpoux;
    }

    public String getPrenomsEpoux() {
        return prenomsEpoux;
    }

    public String getTelephoneEpoux() {
        return telephoneEpoux;
    }

    public LocalDate getDateNaissEpoux() {
        return dateNaissEpoux;
    }

    public String getLieuNaissEpoux() {
        return lieuNaissEpoux;
    }

    public String getProfessionEpoux() {
        return professionEpoux;
    }

    public String getNomPereEpoux() {
        return nomPereEpoux;
    }

    public String getPrenomsPereEpoux() {
        return prenomsPereEpoux;
    }

    public String getNomMereEpoux() {
        return nomMereEpoux;
    }

    public String getPrenomsMereEpoux() {
        return prenomsMereEpoux;
    }

    public String getDomicileEpoux() {
        return domicileEpoux;
    }

    public String getTypePieceIdentEpoux() {
        return typePieceIdentEpoux;
    }

    public String getChemPieceIdentEpoux() {
        return chemPieceIdentEpoux;
    }

    public String getCertifResidenceEpoux() {
        return certifResidenceEpoux;
    }

    public String getNomTemoinEpoux() {
        return nomTemoinEpoux;
    }

    public String getPrenomsTemoinEpoux() {
        return prenomsTemoinEpoux;
    }

    public String getProfessionTemoinEpoux() {
        return professionTemoinEpoux;
    }

    public String getDomicileTemoinEpoux() {
        return domicileTemoinEpoux;
    }

    public String getTypePieceIdentTemoinEpoux() {
        return typePieceIdentTemoinEpoux;
    }

    public String getChemPieceIdentTemoinEpoux() {
        return chemPieceIdentTemoinEpoux;
    }

    public String getPhotoIdentEpoux() {
        return photoIdentEpoux;
    }

    public String getSituationMatriEpoux() {
        return situationMatriEpoux;
    }

    public String getNomEpouse() {
        return nomEpouse;
    }

    public String getPrenomsEpouse() {
        return prenomsEpouse;
    }

    public String getTelephoneEpouse() {
        return telephoneEpouse;
    }

    public LocalDate getDateNaissEpouse() {
        return dateNaissEpouse;
    }

    public String getLieuNaissEpouse() {
        return lieuNaissEpouse;
    }

    public String getProfessionEpouse() {
        return professionEpouse;
    }

    public String getNomPereEpouse() {
        return nomPereEpouse;
    }

    public String getPrenomsPereEpouse() {
        return prenomsPereEpouse;
    }

    public String getNomMereEpouse() {
        return nomMereEpouse;
    }

    public String getPrenomsMereEpouse() {
        return prenomsMereEpouse;
    }

    public String getDomicileEpouse() {
        return domicileEpouse;
    }

    public String getTypePieceIdentEpouse() {
        return typePieceIdentEpouse;
    }

    public String getChemPieceIdentEpouse() {
        return chemPieceIdentEpouse;
    }

    public String getCertifResidenceEpouse() {
        return certifResidenceEpouse;
    }

    public String getNomTemoinEpouse() {
        return nomTemoinEpouse;
    }

    public String getPrenomsTemoinEpouse() {
        return prenomsTemoinEpouse;
    }

    public String getProfessionTemoinEpouse() {
        return professionTemoinEpouse;
    }

    public String getDomicileTemoinEpouse() {
        return domicileTemoinEpouse;
    }

    public String getTypePieceIdentTemoinEpouse() {
        return typePieceIdentTemoinEpouse;
    }

    public String getChemPieceIdentTemoinEpouse() {
        return chemPieceIdentTemoinEpouse;
    }

    public String getPhotoIdentEpouse() {
        return photoIdentEpouse;
    }

    public String getSituationMatriEpouse() {
        return situationMatriEpouse;
    }

    public LocalDateTime getDateRendezVous() {
        return dateRendezVous;
    }

    public String getRegime() {
        return regime;
    }

    public String getStatut() {
        return statut;
    }

    public String getRoleDemandeur() {
        return roleDemandeur;
    }

    public Long getMontant() {
        return montant;
    }

    public Integer getIdEtapeActive() {
        return idEtapeActive;
    }

    public Long getDelaiEtapeActive() {
        return delaiEtapeActive;
    }

    public String getNomEtapeActive() {
        return nomEtapeActive;
    }

    public String getCodeRegistre() {
        return codeRegistre;
    }

    public Long getIdRegistre() {
        return idRegistre;
    }

    public CelebrationMariageDto() {}

    public CelebrationMariageDto(CelebrationMariage celebrationMariage) {
        this.id = celebrationMariage.getId() ;
        this.idUtilisateurDemande = celebrationMariage.getIdUtilisateurDemande() ;
        this.codeDemande = celebrationMariage.getCodeDemande() ;
        this.nomEpoux = celebrationMariage.getNomEpoux() ;
        this.prenomsEpoux = celebrationMariage.getPrenomsEpoux() ;
        this.telephoneEpoux = celebrationMariage.getTelephoneEpoux() ;
        this.dateNaissEpoux = celebrationMariage.getDateNaissEpoux() ;
        this.lieuNaissEpoux = celebrationMariage.getLieuNaissEpoux() ;
        this.professionEpoux = celebrationMariage.getProfessionEpoux() ;
        this.nomPereEpoux = celebrationMariage.getNomPereEpoux() ;
        this.prenomsPereEpoux = celebrationMariage.getPrenomsPereEpoux() ;
        this.nomMereEpoux = celebrationMariage.getNomMereEpoux() ;
        this.prenomsMereEpoux = celebrationMariage.getPrenomsMereEpoux() ;
        this.domicileEpoux = celebrationMariage.getDomicileEpoux() ;
        this.typePieceIdentEpoux = celebrationMariage.getTypePieceIdentEpoux() ;
        this.chemPieceIdentEpoux = celebrationMariage.getChemPieceIdentEpoux() ;
        this.certifResidenceEpoux = celebrationMariage.getCertifResidenceEpoux() ;
        this.nomTemoinEpoux = celebrationMariage.getNomTemoinEpoux() ;
        this.prenomsTemoinEpoux = celebrationMariage.getPrenomsTemoinEpoux() ;
        this.professionTemoinEpoux = celebrationMariage.getProfessionTemoinEpoux() ;
        this.domicileTemoinEpoux = celebrationMariage.getDomicileTemoinEpoux() ;
        this.typePieceIdentTemoinEpoux = celebrationMariage.getTypePieceIdentTemoinEpoux() ;
        this.chemPieceIdentTemoinEpoux = celebrationMariage.getChemPieceIdentTemoinEpoux() ;
        this.photoIdentEpoux = celebrationMariage.getPhotoIdentEpoux() ;
        this.situationMatriEpoux = celebrationMariage.getSituationMatriEpoux() ;
        this.nomEpouse = celebrationMariage.getNomEpouse() ;
        this.prenomsEpouse = celebrationMariage.getPrenomsEpouse() ;
        this.telephoneEpouse = celebrationMariage.getTelephoneEpouse() ;
        this.dateNaissEpouse = celebrationMariage.getDateNaissEpouse() ;
        this.lieuNaissEpouse = celebrationMariage.getLieuNaissEpouse() ;
        this.professionEpouse = celebrationMariage.getProfessionEpouse() ;
        this.nomPereEpouse = celebrationMariage.getNomPereEpouse() ;
        this.prenomsPereEpouse = celebrationMariage.getPrenomsPereEpouse() ;
        this.nomMereEpouse = celebrationMariage.getNomMereEpouse() ;
        this.prenomsMereEpouse = celebrationMariage.getPrenomsMereEpouse() ;
        this.domicileEpouse = celebrationMariage.getDomicileEpouse() ;
        this.typePieceIdentEpouse = celebrationMariage.getTypePieceIdentEpouse() ;
        this.chemPieceIdentEpouse = celebrationMariage.getChemPieceIdentEpouse() ;
        this.certifResidenceEpouse = celebrationMariage.getCertifResidenceEpouse() ;
        this.nomTemoinEpouse = celebrationMariage.getNomTemoinEpouse() ;
        this.prenomsTemoinEpouse = celebrationMariage.getPrenomsTemoinEpouse() ;
        this.professionTemoinEpouse = celebrationMariage.getProfessionTemoinEpouse() ;
        this.domicileTemoinEpouse = celebrationMariage.getDomicileTemoinEpouse() ;
        this.typePieceIdentTemoinEpouse = celebrationMariage.getTypePieceIdentTemoinEpouse() ;
        this.chemPieceIdentTemoinEpouse = celebrationMariage.getChemPieceIdentTemoinEpouse() ;
        this.photoIdentEpouse = celebrationMariage.getPhotoIdentEpouse() ;
        this.situationMatriEpouse = celebrationMariage.getSituationMatriEpouse() ;
        this.dateRendezVous = celebrationMariage.getDateRendezVous() ;
        this.regime = celebrationMariage.getRegime() ;
        this.statut = celebrationMariage.getStatut() ;
        this.roleDemandeur = celebrationMariage.getRoleDemandeur() ;
        this.montant = celebrationMariage.getMontant() ;
        this.idEtapeActive = celebrationMariage.getIdEtapeActive() ;
        this.delaiEtapeActive = celebrationMariage.getDelaiEtapeActive() ;
        this.nomEtapeActive = celebrationMariage.getNomEtapeActive() ;
        this.codeRegistre = celebrationMariage.getCodeRegistre() ;
        this.idRegistre = celebrationMariage.getIdRegistre() ;

    }

    public List<ValidationEtapeInstance> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<ValidationEtapeInstance> etapes) {
        this.etapes = etapes;
    }
}
