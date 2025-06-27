package com.collect.fond.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.MappedSuperclassType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(AbstractEntity.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class AbstractEntity_ {

	
	/**
	 * @see com.collect.fond.domain.AbstractEntity#getCreateBy
	 **/
	public static volatile SingularAttribute<AbstractEntity, String> createBy;
	
	/**
	 * @see com.collect.fond.domain.AbstractEntity#getUpdateBy
	 **/
	public static volatile SingularAttribute<AbstractEntity, String> updateBy;
	
	/**
	 * @see com.collect.fond.domain.AbstractEntity#getUpdateAt
	 **/
	public static volatile SingularAttribute<AbstractEntity, LocalDateTime> updateAt;
	
	/**
	 * @see com.collect.fond.domain.AbstractEntity#getId
	 **/
	public static volatile SingularAttribute<AbstractEntity, Long> id;
	
	/**
	 * @see com.collect.fond.domain.AbstractEntity
	 **/
	public static volatile MappedSuperclassType<AbstractEntity> class_;
	
	/**
	 * @see com.collect.fond.domain.AbstractEntity#getVersion
	 **/
	public static volatile SingularAttribute<AbstractEntity, Long> version;
	
	/**
	 * @see com.collect.fond.domain.AbstractEntity#getCreateAt
	 **/
	public static volatile SingularAttribute<AbstractEntity, LocalDateTime> createAt;

	public static final String CREATE_BY = "createBy";
	public static final String UPDATE_BY = "updateBy";
	public static final String UPDATE_AT = "updateAt";
	public static final String ID = "id";
	public static final String VERSION = "version";
	public static final String CREATE_AT = "createAt";

}

