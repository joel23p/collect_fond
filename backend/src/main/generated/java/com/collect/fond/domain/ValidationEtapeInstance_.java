package com.collect.fond.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(ValidationEtapeInstance.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class ValidationEtapeInstance_ extends com.collect.fond.domain.AbstractEntity_ {

	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#delaiJours
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, Integer> delaiJours;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#idUtilisateurValidation
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, Long> idUtilisateurValidation;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#idDemande
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, Long> idDemande;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#numeroEtape
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, Integer> numeroEtape;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#usernameValidation
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, String> usernameValidation;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#nomEtape
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, String> nomEtape;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#nomPrenomValidation
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, String> nomPrenomValidation;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#typeDemande
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, String> typeDemande;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#datePrevision
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, LocalDateTime> datePrevision;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#idConfig
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, Long> idConfig;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#dateDebut
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, LocalDateTime> dateDebut;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#valeurExtra
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, String> valeurExtra;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#id
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, Long> id;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#dateFin
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, LocalDateTime> dateFin;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance
	 **/
	public static volatile EntityType<ValidationEtapeInstance> class_;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#commentaire
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, String> commentaire;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#statut
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, String> statut;
	
	/**
	 * @see com.collect.fond.domain.ValidationEtapeInstance#evenementSucces
	 **/
	public static volatile SingularAttribute<ValidationEtapeInstance, String> evenementSucces;

	public static final String DELAI_JOURS = "delaiJours";
	public static final String ID_UTILISATEUR_VALIDATION = "idUtilisateurValidation";
	public static final String ID_DEMANDE = "idDemande";
	public static final String NUMERO_ETAPE = "numeroEtape";
	public static final String USERNAME_VALIDATION = "usernameValidation";
	public static final String NOM_ETAPE = "nomEtape";
	public static final String NOM_PRENOM_VALIDATION = "nomPrenomValidation";
	public static final String TYPE_DEMANDE = "typeDemande";
	public static final String DATE_PREVISION = "datePrevision";
	public static final String ID_CONFIG = "idConfig";
	public static final String DATE_DEBUT = "dateDebut";
	public static final String VALEUR_EXTRA = "valeurExtra";
	public static final String ID = "id";
	public static final String DATE_FIN = "dateFin";
	public static final String COMMENTAIRE = "commentaire";
	public static final String STATUT = "statut";
	public static final String EVENEMENT_SUCCES = "evenementSucces";

}

