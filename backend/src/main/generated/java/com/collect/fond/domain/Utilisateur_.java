package com.collect.fond.domain;

import com.collect.fond.enums.Role;
import com.collect.fond.enums.StatutUtilisateur;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Utilisateur.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Utilisateur_ extends com.collect.fond.domain.AbstractEntity_ {

	
	/**
	 * @see com.collect.fond.domain.Utilisateur#password
	 **/
	public static volatile SingularAttribute<Utilisateur, String> password;
	
	/**
	 * @see com.collect.fond.domain.Utilisateur#role
	 **/
	public static volatile SingularAttribute<Utilisateur, Role> role;
	
	/**
	 * @see com.collect.fond.domain.Utilisateur#id
	 **/
	public static volatile SingularAttribute<Utilisateur, Long> id;
	
	/**
	 * @see com.collect.fond.domain.Utilisateur
	 **/
	public static volatile EntityType<Utilisateur> class_;
	
	/**
	 * @see com.collect.fond.domain.Utilisateur#nom
	 **/
	public static volatile SingularAttribute<Utilisateur, String> nom;
	
	/**
	 * @see com.collect.fond.domain.Utilisateur#statut
	 **/
	public static volatile SingularAttribute<Utilisateur, StatutUtilisateur> statut;
	
	/**
	 * @see com.collect.fond.domain.Utilisateur#username
	 **/
	public static volatile SingularAttribute<Utilisateur, String> username;
	
	/**
	 * @see com.collect.fond.domain.Utilisateur#prenoms
	 **/
	public static volatile SingularAttribute<Utilisateur, String> prenoms;

	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String ID = "id";
	public static final String NOM = "nom";
	public static final String STATUT = "statut";
	public static final String USERNAME = "username";
	public static final String PRENOMS = "prenoms";

}

