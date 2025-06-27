package com.collect.fond.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Paiements.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Paiements_ extends com.collect.fond.domain.AbstractEntity_ {

	
	/**
	 * @see com.collect.fond.domain.Paiements#datePaiement
	 **/
	public static volatile SingularAttribute<Paiements, LocalDateTime> datePaiement;
	
	/**
	 * @see com.collect.fond.domain.Paiements#montant
	 **/
	public static volatile SingularAttribute<Paiements, Long> montant;
	
	/**
	 * @see com.collect.fond.domain.Paiements#id
	 **/
	public static volatile SingularAttribute<Paiements, Long> id;
	
	/**
	 * @see com.collect.fond.domain.Paiements
	 **/
	public static volatile EntityType<Paiements> class_;
	
	/**
	 * @see com.collect.fond.domain.Paiements#membres
	 **/
	public static volatile SingularAttribute<Paiements, Membres> membres;
	
	/**
	 * @see com.collect.fond.domain.Paiements#info
	 **/
	public static volatile SingularAttribute<Paiements, String> info;

	public static final String DATE_PAIEMENT = "datePaiement";
	public static final String MONTANT = "montant";
	public static final String ID = "id";
	public static final String MEMBRES = "membres";
	public static final String INFO = "info";

}

