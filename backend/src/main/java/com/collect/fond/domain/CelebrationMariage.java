package com.collect.fond.domain;

import com.collect.fond.presentation.dto.CelebrationMariageDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
@Table(name = CelebrationMariage.TABLE_NAME)
public class CelebrationMariage extends AbstractEntity {

    public static final String TABLE_NAME = "celebration_mariage";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = "celebration_mariage_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "id_utilisateur_demande")
    private Long idUtilisateurDemande;

    @Column(name = "code_demande")
    private String codeDemande;

    @Column(name = "nom_epoux")
    private String nomEpoux;

    @Column(name = "prenoms_epoux")
    private String prenomsEpoux;

    @Column(name = "telephone_epoux")
    private String telephoneEpoux;

    @Column(name = "date_naiss_epoux")
    private LocalDate dateNaissEpoux;

    @Column(name = "lieu_naiss_epoux")
    private String lieuNaissEpoux;

    @Column(name = "profession_epoux")
    private String professionEpoux;

    @Column(name = "nom_pere_epoux")
    private String nomPereEpoux;

    @Column(name = "prenoms_pere_epoux")
    private String prenomsPereEpoux;

    @Column(name = "nom_mere_epoux")
    private String nomMereEpoux;

    @Column(name = "prenoms_mere_epoux")
    private String prenomsMereEpoux;

    @Column(name = "domicile_epoux")
    private String domicileEpoux;

    @Column(name = "type_piece_ident_epoux")
    private String typePieceIdentEpoux;

    @Column(name = "chem_piece_ident_epoux")
    private String chemPieceIdentEpoux;

    @Column(name = "certif_residence_epoux")
    private String certifResidenceEpoux;

    @Column(name = "nom_temoin_epoux")
    private String nomTemoinEpoux;

    @Column(name = "prenoms_temoin_epoux")
    private String prenomsTemoinEpoux;

    @Column(name = "profession_temoin_epoux")
    private String professionTemoinEpoux;

    @Column(name = "domicile_temoin_epoux")
    private String domicileTemoinEpoux;

    @Column(name = "type_piece_ident_temoin_epoux")
    private String typePieceIdentTemoinEpoux;

    @Column(name = "chem_piece_ident_temoin_epoux")
    private String chemPieceIdentTemoinEpoux;

    @Column(name = "photo_ident_epoux")
    private String photoIdentEpoux;

    @Column(name = "situation_matri_epoux")
    private String situationMatriEpoux;

    @Column(name = "nom_epouse")
    private String nomEpouse;

    @Column(name = "prenoms_epouse")
    private String prenomsEpouse;

    @Column(name = "telephone_epouse")
    private String telephoneEpouse;

    @Column(name = "date_naiss_epouse")
    private LocalDate dateNaissEpouse;

    @Column(name = "lieu_naiss_epouse")
    private String lieuNaissEpouse;

    @Column(name = "profession_epouse")
    private String professionEpouse;

    @Column(name = "nom_pere_epouse")
    private String nomPereEpouse;

    @Column(name = "prenoms_pere_epouse")
    private String prenomsPereEpouse;

    @Column(name = "nom_mere_epouse")
    private String nomMereEpouse;

    @Column(name = "prenoms_mere_epouse")
    private String prenomsMereEpouse;

    @Column(name = "domicile_epouse")
    private String domicileEpouse;

    @Column(name = "type_piece_ident_epouse")
    private String typePieceIdentEpouse;

    @Column(name = "chem_piece_ident_epouse")
    private String chemPieceIdentEpouse;

    @Column(name = "certif_residence_epouse")
    private String certifResidenceEpouse;

    @Column(name = "nom_temoin_epouse")
    private String nomTemoinEpouse;

    @Column(name = "prenoms_temoin_epouse")
    private String prenomsTemoinEpouse;

    @Column(name = "profession_temoin_epouse")
    private String professionTemoinEpouse;

    @Column(name = "domicile_temoin_epouse")
    private String domicileTemoinEpouse;

    @Column(name = "type_piece_ident_temoin_epouse")
    private String typePieceIdentTemoinEpouse;

    @Column(name = "chem_piece_ident_temoin_epouse")
    private String chemPieceIdentTemoinEpouse;

    @Column(name = "photo_ident_epouse")
    private String photoIdentEpouse;

    @Column(name = "situation_matri_epouse")
    private String situationMatriEpouse;

    @Column(name = "date_rendez_vous")
    private LocalDateTime dateRendezVous;

    @Column(name = "regime", length = 50)
    private String regime = "COMMUNAUTE_BIEN";

    @Column(name = "statut", length = 50)
    private String statut = "NON_DEMARRE";

    @Column(name = "role_demandeur", length = 50)
    private String roleDemandeur = "EPOUX";

    @Column(name = "montant")
    private Long montant;

    @Column(name = "id_etape_active")
    private Integer idEtapeActive;

    @Column(name = "delai_etape_active")
    private Long delaiEtapeActive;

    @Column(name = "nom_etape_active")
    private String nomEtapeActive;

    @Column(name = "code_registre")
    private String codeRegistre;

    @Column(name = "id_registre")
    private Long idRegistre;

    public CelebrationMariage() {}

    public CelebrationMariage(CelebrationMariageDto celebrationMariageDto) {
        this.idUtilisateurDemande = celebrationMariageDto.getIdUtilisateurDemande() ;
        this.codeDemande = celebrationMariageDto.getCodeDemande() ;
        this.nomEpoux = celebrationMariageDto.getNomEpoux() ;
        this.prenomsEpoux = celebrationMariageDto.getPrenomsEpoux() ;
        this.telephoneEpoux = celebrationMariageDto.getTelephoneEpoux() ;
        this.dateNaissEpoux = celebrationMariageDto.getDateNaissEpoux() ;
        this.lieuNaissEpoux = celebrationMariageDto.getLieuNaissEpoux() ;
        this.professionEpoux = celebrationMariageDto.getProfessionEpoux() ;
        this.nomPereEpoux = celebrationMariageDto.getNomPereEpoux() ;
        this.prenomsPereEpoux = celebrationMariageDto.getPrenomsPereEpoux() ;
        this.nomMereEpoux = celebrationMariageDto.getNomMereEpoux() ;
        this.prenomsMereEpoux = celebrationMariageDto.getPrenomsMereEpoux() ;
        this.domicileEpoux = celebrationMariageDto.getDomicileEpoux() ;
        this.typePieceIdentEpoux = celebrationMariageDto.getTypePieceIdentEpoux() ;
        this.chemPieceIdentEpoux = celebrationMariageDto.getChemPieceIdentEpoux() ;
        this.certifResidenceEpoux = celebrationMariageDto.getCertifResidenceEpoux() ;
        this.nomTemoinEpoux = celebrationMariageDto.getNomTemoinEpoux() ;
        this.prenomsTemoinEpoux = celebrationMariageDto.getPrenomsTemoinEpoux() ;
        this.professionTemoinEpoux = celebrationMariageDto.getProfessionTemoinEpoux() ;
        this.domicileTemoinEpoux = celebrationMariageDto.getDomicileTemoinEpoux() ;
        this.typePieceIdentTemoinEpoux = celebrationMariageDto.getTypePieceIdentTemoinEpoux() ;
        this.chemPieceIdentTemoinEpoux = celebrationMariageDto.getChemPieceIdentTemoinEpoux() ;
        this.photoIdentEpoux = celebrationMariageDto.getPhotoIdentEpoux() ;
        this.situationMatriEpoux = celebrationMariageDto.getSituationMatriEpoux() ;
        this.nomEpouse = celebrationMariageDto.getNomEpouse() ;
        this.prenomsEpouse = celebrationMariageDto.getPrenomsEpouse() ;
        this.telephoneEpouse = celebrationMariageDto.getTelephoneEpouse() ;
        this.dateNaissEpouse = celebrationMariageDto.getDateNaissEpouse() ;
        this.lieuNaissEpouse = celebrationMariageDto.getLieuNaissEpouse() ;
        this.professionEpouse = celebrationMariageDto.getProfessionEpouse() ;
        this.nomPereEpouse = celebrationMariageDto.getNomPereEpouse() ;
        this.prenomsPereEpouse = celebrationMariageDto.getPrenomsPereEpouse() ;
        this.nomMereEpouse = celebrationMariageDto.getNomMereEpouse() ;
        this.prenomsMereEpouse = celebrationMariageDto.getPrenomsMereEpouse() ;
        this.domicileEpouse = celebrationMariageDto.getDomicileEpouse() ;
        this.typePieceIdentEpouse = celebrationMariageDto.getTypePieceIdentEpouse() ;
        this.chemPieceIdentEpouse = celebrationMariageDto.getChemPieceIdentEpouse() ;
        this.certifResidenceEpouse = celebrationMariageDto.getCertifResidenceEpouse() ;
        this.nomTemoinEpouse = celebrationMariageDto.getNomTemoinEpouse() ;
        this.prenomsTemoinEpouse = celebrationMariageDto.getPrenomsTemoinEpouse() ;
        this.professionTemoinEpouse = celebrationMariageDto.getProfessionTemoinEpouse() ;
        this.domicileTemoinEpouse = celebrationMariageDto.getDomicileTemoinEpouse() ;
        this.typePieceIdentTemoinEpouse = celebrationMariageDto.getTypePieceIdentTemoinEpouse() ;
        this.chemPieceIdentTemoinEpouse = celebrationMariageDto.getChemPieceIdentTemoinEpouse() ;
        this.photoIdentEpouse = celebrationMariageDto.getPhotoIdentEpouse() ;
        this.situationMatriEpouse = celebrationMariageDto.getSituationMatriEpouse() ;
        this.dateRendezVous = celebrationMariageDto.getDateRendezVous() ;
        this.regime = celebrationMariageDto.getRegime() ;
        this.statut = celebrationMariageDto.getStatut() ;
        this.roleDemandeur = celebrationMariageDto.getRoleDemandeur() ;
        this.montant = celebrationMariageDto.getMontant() ;
        this.idEtapeActive = celebrationMariageDto.getIdEtapeActive() ;
        this.delaiEtapeActive = celebrationMariageDto.getDelaiEtapeActive() ;
        this.nomEtapeActive = celebrationMariageDto.getNomEtapeActive() ;
        this.codeRegistre = celebrationMariageDto.getCodeRegistre() ;
        this.idRegistre = celebrationMariageDto.getIdRegistre() ;
    }

    public CelebrationMariage(Long idUtilisateurDemande, String codeDemande, String nomEpoux, String prenomsEpoux, String telephoneEpoux, LocalDate dateNaissEpoux, String lieuNaissEpoux, String professionEpoux, String nomPereEpoux, String prenomsPereEpoux, String nomMereEpoux, String prenomsMereEpoux, String domicileEpoux, String typePieceIdentEpoux, String chemPieceIdentEpoux, String certifResidenceEpoux, String nomTemoinEpoux, String prenomsTemoinEpoux, String professionTemoinEpoux, String domicileTemoinEpoux, String typePieceIdentTemoinEpoux, String chemPieceIdentTemoinEpoux, String photoIdentEpoux, String situationMatriEpoux, String nomEpouse, String prenomsEpouse, String telephoneEpouse, LocalDate dateNaissEpouse, String lieuNaissEpouse, String professionEpouse, String nomPereEpouse, String prenomsPereEpouse, String nomMereEpouse, String prenomsMereEpouse, String domicileEpouse, String typePieceIdentEpouse, String chemPieceIdentEpouse, String certifResidenceEpouse, String nomTemoinEpouse, String prenomsTemoinEpouse, String professionTemoinEpouse, String domicileTemoinEpouse, String typePieceIdentTemoinEpouse, String chemPieceIdentTemoinEpouse, String photoIdentEpouse, String situationMatriEpouse, LocalDateTime dateRendezVous, String regime, String statut, String roleDemandeur, Long montant, Integer idEtapeActive, Long delaiEtapeActive, String nomEtapeActive, String codeRegistre, Long idRegistre) {
        this.idUtilisateurDemande = idUtilisateurDemande;
        this.codeDemande = codeDemande;
        this.nomEpoux = nomEpoux;
        this.prenomsEpoux = prenomsEpoux;
        this.telephoneEpoux = telephoneEpoux;
        this.dateNaissEpoux = dateNaissEpoux;
        this.lieuNaissEpoux = lieuNaissEpoux;
        this.professionEpoux = professionEpoux;
        this.nomPereEpoux = nomPereEpoux;
        this.prenomsPereEpoux = prenomsPereEpoux;
        this.nomMereEpoux = nomMereEpoux;
        this.prenomsMereEpoux = prenomsMereEpoux;
        this.domicileEpoux = domicileEpoux;
        this.typePieceIdentEpoux = typePieceIdentEpoux;
        this.chemPieceIdentEpoux = chemPieceIdentEpoux;
        this.certifResidenceEpoux = certifResidenceEpoux;
        this.nomTemoinEpoux = nomTemoinEpoux;
        this.prenomsTemoinEpoux = prenomsTemoinEpoux;
        this.professionTemoinEpoux = professionTemoinEpoux;
        this.domicileTemoinEpoux = domicileTemoinEpoux;
        this.typePieceIdentTemoinEpoux = typePieceIdentTemoinEpoux;
        this.chemPieceIdentTemoinEpoux = chemPieceIdentTemoinEpoux;
        this.photoIdentEpoux = photoIdentEpoux;
        this.situationMatriEpoux = situationMatriEpoux;
        this.nomEpouse = nomEpouse;
        this.prenomsEpouse = prenomsEpouse;
        this.telephoneEpouse = telephoneEpouse;
        this.dateNaissEpouse = dateNaissEpouse;
        this.lieuNaissEpouse = lieuNaissEpouse;
        this.professionEpouse = professionEpouse;
        this.nomPereEpouse = nomPereEpouse;
        this.prenomsPereEpouse = prenomsPereEpouse;
        this.nomMereEpouse = nomMereEpouse;
        this.prenomsMereEpouse = prenomsMereEpouse;
        this.domicileEpouse = domicileEpouse;
        this.typePieceIdentEpouse = typePieceIdentEpouse;
        this.chemPieceIdentEpouse = chemPieceIdentEpouse;
        this.certifResidenceEpouse = certifResidenceEpouse;
        this.nomTemoinEpouse = nomTemoinEpouse;
        this.prenomsTemoinEpouse = prenomsTemoinEpouse;
        this.professionTemoinEpouse = professionTemoinEpouse;
        this.domicileTemoinEpouse = domicileTemoinEpouse;
        this.typePieceIdentTemoinEpouse = typePieceIdentTemoinEpouse;
        this.chemPieceIdentTemoinEpouse = chemPieceIdentTemoinEpouse;
        this.photoIdentEpouse = photoIdentEpouse;
        this.situationMatriEpouse = situationMatriEpouse;
        this.dateRendezVous = dateRendezVous;
        this.regime = regime;
        this.statut = statut;
        this.roleDemandeur = roleDemandeur;
        this.montant = montant;
        this.idEtapeActive = idEtapeActive;
        this.delaiEtapeActive = delaiEtapeActive;
        this.nomEtapeActive = nomEtapeActive;
        this.codeRegistre = codeRegistre;
        this.idRegistre = idRegistre;
    }

    public CelebrationMariage(Long id, String nomEpoux, String prenomsEpoux, String telephoneEpoux, LocalDate dateNaissEpoux, String lieuNaissEpoux, String professionEpoux, String nomPereEpoux, String nomMereEpoux, String prenomsPereEpoux, String prenomsMereEpoux, String typePieceIdentEpoux, String domicileEpoux, String chemPieceIdentEpoux, String certifResidenceEpoux, String nomTemoinEpoux, String prenomsTemoinEpoux, String professionTemoinEpoux, String domicileTemoinEpoux, String typePieceIdentTemoinEpoux, String chemPieceIdentTemoinEpoux, String photoIdentEpoux, String situationMatriEpoux, String nomEpouse, String prenomsEpouse, String telephoneEpouse, LocalDate dateNaissEpouse, String lieuNaissEpouse, String professionEpouse, String nomPereEpouse, String prenomsPereEpouse, String nomMereEpouse, String prenomsMereEpouse, String domicileEpouse, String typePieceIdentEpouse, String chemPieceIdentEpouse, String certifResidenceEpouse, String nomTemoinEpouse, String prenomsTemoinEpouse, String professionTemoinEpouse, String domicileTemoinEpouse, String typePieceIdentTemoinEpouse, String chemPieceIdentTemoinEpouse, String photoIdentEpouse, String situationMatriEpouse, LocalDateTime dateRendezVous, String regime, String statut, String roleDemandeur, Long montant, Integer idEtapeActive, Long delaiEtapeActive, String nomEtapeActive) {
        this.id = id;
        this.nomEpoux = nomEpoux;
        this.prenomsEpoux = prenomsEpoux;
        this.telephoneEpoux = telephoneEpoux;
        this.dateNaissEpoux = dateNaissEpoux;
        this.lieuNaissEpoux = lieuNaissEpoux;
        this.professionEpoux = professionEpoux;
        this.nomPereEpoux = nomPereEpoux;
        this.nomMereEpoux = nomMereEpoux;
        this.prenomsPereEpoux = prenomsPereEpoux;
        this.prenomsMereEpoux = prenomsMereEpoux;
        this.typePieceIdentEpoux = typePieceIdentEpoux;
        this.domicileEpoux = domicileEpoux;
        this.chemPieceIdentEpoux = chemPieceIdentEpoux;
        this.certifResidenceEpoux = certifResidenceEpoux;
        this.nomTemoinEpoux = nomTemoinEpoux;
        this.prenomsTemoinEpoux = prenomsTemoinEpoux;
        this.professionTemoinEpoux = professionTemoinEpoux;
        this.domicileTemoinEpoux = domicileTemoinEpoux;
        this.typePieceIdentTemoinEpoux = typePieceIdentTemoinEpoux;
        this.chemPieceIdentTemoinEpoux = chemPieceIdentTemoinEpoux;
        this.photoIdentEpoux = photoIdentEpoux;
        this.situationMatriEpoux = situationMatriEpoux;
        this.nomEpouse = nomEpouse;
        this.prenomsEpouse = prenomsEpouse;
        this.telephoneEpouse = telephoneEpouse;
        this.dateNaissEpouse = dateNaissEpouse;
        this.lieuNaissEpouse = lieuNaissEpouse;
        this.professionEpouse = professionEpouse;
        this.nomPereEpouse = nomPereEpouse;
        this.prenomsPereEpouse = prenomsPereEpouse;
        this.nomMereEpouse = nomMereEpouse;
        this.prenomsMereEpouse = prenomsMereEpouse;
        this.domicileEpouse = domicileEpouse;
        this.typePieceIdentEpouse = typePieceIdentEpouse;
        this.chemPieceIdentEpouse = chemPieceIdentEpouse;
        this.certifResidenceEpouse = certifResidenceEpouse;
        this.nomTemoinEpouse = nomTemoinEpouse;
        this.prenomsTemoinEpouse = prenomsTemoinEpouse;
        this.professionTemoinEpouse = professionTemoinEpouse;
        this.domicileTemoinEpouse = domicileTemoinEpouse;
        this.typePieceIdentTemoinEpouse = typePieceIdentTemoinEpouse;
        this.chemPieceIdentTemoinEpouse = chemPieceIdentTemoinEpouse;
        this.photoIdentEpouse = photoIdentEpouse;
        this.situationMatriEpouse = situationMatriEpouse;
        this.dateRendezVous = dateRendezVous;
        this.regime = regime;
        this.statut = statut;
        this.roleDemandeur = roleDemandeur;
        this.montant = montant;
        this.idEtapeActive = idEtapeActive;
        this.delaiEtapeActive = delaiEtapeActive;
        this.nomEtapeActive = nomEtapeActive;
    }

    public CelebrationMariage(String nomEpoux, String prenomsEpoux, String telephoneEpoux,
                              LocalDate dateNaissEpoux, String lieuNaissEpoux,
                              String professionEpoux, String nomPereEpoux,
                              String prenomsPereEpoux, String nomMereEpoux, String prenomsMereEpoux,
                              String domicileEpoux, String typePieceIdentEpoux, String chemPieceIdentEpoux,
                              String certifResidenceEpoux, String nomTemoinEpoux, String prenomsTemoinEpoux,
                              String professionTemoinEpoux,
                              String domicileTemoinEpoux, String typePieceIdentTemoinEpoux,
                              String chemPieceIdentTemoinEpoux, String photoIdentEpoux,
                              String situationMatriEpoux, String nomEpouse,
                              String prenomsEpouse, String telephoneEpouse,
                              LocalDate dateNaissEpouse, String lieuNaissEpouse,
                              String professionEpouse, String nomPereEpouse, String prenomsPereEpouse, String nomMereEpouse, String prenomsMereEpouse,
                              String domicileEpouse, String typePieceIdentEpouse, String chemPieceIdentEpouse, String certifResidenceEpouse,
                              String nomTemoinEpouse, String prenomsTemoinEpouse, String professionTemoinEpouse, String domicileTemoinEpouse, String typePieceIdentTemoinEpouse,
                              String chemPieceIdentTemoinEpouse, String photoIdentEpouse, String situationMatriEpouse, LocalDateTime dateRendezVous,
                              String regime, String statut, String roleDemandeur, Long montant, Integer idEtapeActive, Long delaiEtapeActive, String nomEtapeActive) {
    this.nomEpoux = nomEpoux;
    this.prenomsEpoux = prenomsEpoux;
    this.telephoneEpoux = telephoneEpoux;
    this.dateNaissEpoux = dateNaissEpoux;
    this.lieuNaissEpoux = lieuNaissEpoux;
    this.professionEpoux = professionEpoux;
    this.nomPereEpoux = nomPereEpoux;
    this.prenomsPereEpoux = prenomsPereEpoux;
    this.nomMereEpoux = nomMereEpoux;
    this.prenomsMereEpoux = prenomsMereEpoux;
    this.domicileEpoux = domicileEpoux;
    this.typePieceIdentEpoux = typePieceIdentEpoux;
    this.chemPieceIdentEpoux = chemPieceIdentEpoux;
    this.certifResidenceEpoux = certifResidenceEpoux;
    this.nomTemoinEpoux = nomTemoinEpoux;
    this.prenomsTemoinEpoux = prenomsTemoinEpoux;
    this.professionTemoinEpoux = professionTemoinEpoux;
    this.domicileTemoinEpoux = domicileTemoinEpoux;
    this.typePieceIdentTemoinEpoux = typePieceIdentTemoinEpoux;
    this.chemPieceIdentTemoinEpoux = chemPieceIdentTemoinEpoux;
    this.photoIdentEpoux = photoIdentEpoux;
    this.situationMatriEpoux = situationMatriEpoux;
    this.nomEpouse = nomEpouse;
    this.prenomsEpouse = prenomsEpouse;
    this.telephoneEpouse = telephoneEpouse;
    this.dateNaissEpouse = dateNaissEpouse;
    this.lieuNaissEpouse = lieuNaissEpouse;
    this.professionEpouse = professionEpouse;
    this.nomPereEpouse = nomPereEpouse;
    this.prenomsPereEpouse = prenomsPereEpouse;
    this.nomMereEpouse = nomMereEpouse;
    this.prenomsMereEpouse = prenomsMereEpouse;
    this.domicileEpouse = domicileEpouse;
    this.typePieceIdentEpouse = typePieceIdentEpouse;
    this.chemPieceIdentEpouse = chemPieceIdentEpouse;
    this.certifResidenceEpouse = certifResidenceEpouse;
    this.nomTemoinEpouse = nomTemoinEpouse;
    this.prenomsTemoinEpouse = prenomsTemoinEpouse;
    this.professionTemoinEpouse = professionTemoinEpouse;
    this.domicileTemoinEpouse = domicileTemoinEpouse;
    this.typePieceIdentTemoinEpouse = typePieceIdentTemoinEpouse;
    this.chemPieceIdentTemoinEpouse = chemPieceIdentTemoinEpouse;
    this.photoIdentEpouse = photoIdentEpouse;
    this.situationMatriEpouse = situationMatriEpouse;
    this.dateRendezVous = dateRendezVous;
    this.regime = regime;
    this.statut = statut;
    this.roleDemandeur = roleDemandeur;
    this.montant = montant;
    this.idEtapeActive = idEtapeActive;
    this.delaiEtapeActive = delaiEtapeActive;
    this.nomEtapeActive = nomEtapeActive;

    }


    public Long getId() { return id; }

    public String getNomEpoux() { return nomEpoux; }
    public void setNomEpoux(String nomEpoux) { this.nomEpoux = nomEpoux; }

    public String getPrenomsEpoux() { return prenomsEpoux; }
    public void setPrenomsEpoux(String prenomsEpoux) { this.prenomsEpoux = prenomsEpoux; }

    public String getTelephoneEpoux() { return telephoneEpoux; }
    public void setTelephoneEpoux(String telephoneEpoux) { this.telephoneEpoux = telephoneEpoux; }

    public LocalDate getDateNaissEpoux() { return dateNaissEpoux; }
    public void setDateNaissEpoux(LocalDate dateNaissEpoux) { this.dateNaissEpoux = dateNaissEpoux; }

    public String getNomEpouse() { return nomEpouse; }
    public void setNomEpouse(String nomEpouse) { this.nomEpouse = nomEpouse; }

    public String getPrenomsEpouse() { return prenomsEpouse; }
    public void setPrenomsEpouse(String prenomsEpouse) { this.prenomsEpouse = prenomsEpouse; }

    public String getTelephoneEpouse() { return telephoneEpouse; }
    public void setTelephoneEpouse(String telephoneEpouse) { this.telephoneEpouse = telephoneEpouse; }

    public LocalDate getDateNaissEpouse() { return dateNaissEpouse; }
    public void setDateNaissEpouse(LocalDate dateNaissEpouse) { this.dateNaissEpouse = dateNaissEpouse; }

    public LocalDateTime getDateRendezVous() { return dateRendezVous; }
    public void setDateRendezVous(LocalDateTime dateRendezVous) { this.dateRendezVous = dateRendezVous; }

    public String getRegime() { return regime; }
    public void setRegime(String regime) { this.regime = regime; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public String getRoleDemandeur() { return roleDemandeur; }
    public void setRoleDemandeur(String roleDemandeur) { this.roleDemandeur = roleDemandeur; }

    public Long getMontant() { return montant; }
    public void setMontant(Long montant) { this.montant = montant; }

    public Integer getIdEtapeActive() { return idEtapeActive; }
    public void setIdEtapeActive(Integer idEtapeActive) { this.idEtapeActive = idEtapeActive; }

    public Long getDelaiEtapeActive() { return delaiEtapeActive; }
    public void setDelaiEtapeActive(Long delaiEtapeActive) { this.delaiEtapeActive = delaiEtapeActive; }

    public String getNomEtapeActive() { return nomEtapeActive; }
    public void setNomEtapeActive(String nomEtapeActive) { this.nomEtapeActive = nomEtapeActive; }
    public String getLieuNaissEpoux() { return lieuNaissEpoux; }
    public String getProfessionEpoux() { return professionEpoux; }
    public String getNomPereEpoux() { return nomPereEpoux; }
    public String getPrenomsPereEpoux() { return prenomsPereEpoux; }
    public String getNomMereEpoux() { return nomMereEpoux; }
    public String getPrenomsMereEpoux() { return prenomsMereEpoux; }
    public String getDomicileEpoux() { return domicileEpoux; }
    public String getTypePieceIdentEpoux() { return typePieceIdentEpoux; }
    public String getChemPieceIdentEpoux() { return chemPieceIdentEpoux; }
    public String getCertifResidenceEpoux() { return certifResidenceEpoux; }
    public String getNomTemoinEpoux() { return nomTemoinEpoux; }
    public String getPrenomsTemoinEpoux() { return prenomsTemoinEpoux; }
    public String getProfessionTemoinEpoux() { return professionTemoinEpoux; }
    public String getDomicileTemoinEpoux() { return domicileTemoinEpoux; }
    public String getTypePieceIdentTemoinEpoux() { return typePieceIdentTemoinEpoux; }
    public String getChemPieceIdentTemoinEpoux() { return chemPieceIdentTemoinEpoux; }
    public String getPhotoIdentEpoux() { return photoIdentEpoux; }
    public String getSituationMatriEpoux() { return situationMatriEpoux; }
    public String getLieuNaissEpouse() { return lieuNaissEpouse; }
    public String getProfessionEpouse() { return professionEpouse; }
    public String getNomPereEpouse() { return nomPereEpouse; }
    public String getPrenomsPereEpouse() { return prenomsPereEpouse; }
    public String getNomMereEpouse() { return nomMereEpouse; }
    public String getPrenomsMereEpouse() { return prenomsMereEpouse; }
    public String getDomicileEpouse() { return domicileEpouse; }
    public String getTypePieceIdentEpouse() { return typePieceIdentEpouse; }
    public String getChemPieceIdentEpouse() { return chemPieceIdentEpouse; }
    public String getCertifResidenceEpouse() { return certifResidenceEpouse; }
    public String getNomTemoinEpouse() { return nomTemoinEpouse; }
    public String getPrenomsTemoinEpouse() { return prenomsTemoinEpouse; }
    public String getProfessionTemoinEpouse() { return professionTemoinEpouse; }
    public String getDomicileTemoinEpouse() { return domicileTemoinEpouse; }
    public String getTypePieceIdentTemoinEpouse() { return typePieceIdentTemoinEpouse; }
    public String getChemPieceIdentTemoinEpouse() { return chemPieceIdentTemoinEpouse; }
    public String getPhotoIdentEpouse() { return photoIdentEpouse; }
    public String getSituationMatriEpouse() { return situationMatriEpouse; }

    public String getCodeRegistre() {
        return codeRegistre;
    }

    public void setCodeRegistre(String codeRegistre) {
        this.codeRegistre = codeRegistre;
    }

    public Long getIdRegistre() {
        return idRegistre;
    }

    public void setIdRegistre(Long idRegistre) {
        this.idRegistre = idRegistre;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    public Long getIdUtilisateurDemande() {
        return idUtilisateurDemande;
    }

    public void setIdUtilisateurDemande(Long idUtilisateurDemande) {
        this.idUtilisateurDemande = idUtilisateurDemande;
    }



}
