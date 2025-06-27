package com.collect.fond.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Membres.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Membres_ extends com.collect.fond.domain.AbstractEntity_ {

	
	/**
	 * @see com.collect.fond.domain.Membres#formule
	 **/
	public static volatile SingularAttribute<Membres, String> formule;
	
	/**
	 * @see com.collect.fond.domain.Membres#dateInscription
	 **/
	public static volatile SingularAttribute<Membres, LocalDateTime> dateInscription;
	
	/**
	 * @see com.collect.fond.domain.Membres#telephone
	 **/
	public static volatile SingularAttribute<Membres, String> telephone;
	
	/**
	 * @see com.collect.fond.domain.Membres#id
	 **/
	public static volatile SingularAttribute<Membres, Long> id;
	
	/**
	 * @see com.collect.fond.domain.Membres
	 **/
	public static volatile EntityType<Membres> class_;
	
	/**
	 * @see com.collect.fond.domain.Membres#nom
	 **/
	public static volatile SingularAttribute<Membres, String> nom;
	
	/**
	 * @see com.collect.fond.domain.Membres#email
	 **/
	public static volatile SingularAttribute<Membres, String> email;
	
	/**
	 * @see com.collect.fond.domain.Membres#prenoms
	 **/
	public static volatile SingularAttribute<Membres, String> prenoms;

	public static final String FORMULE = "formule";
	public static final String DATE_INSCRIPTION = "dateInscription";
	public static final String TELEPHONE = "telephone";
	public static final String ID = "id";
	public static final String NOM = "nom";
	public static final String EMAIL = "email";
	public static final String PRENOMS = "prenoms";

}

