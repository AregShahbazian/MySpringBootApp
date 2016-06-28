package com.myspingbootapp.domain.model;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "domain_entity")
@ApiModel(value = "DomainEntity", description = "DomainEntity description")
public class DomainEntitySimple
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "entity_name", nullable = false)
	@Length(max = 20, message = "entity_name can not exceed 20 characters")
	@NotNull(message = "entity_name can not be null")
	@ApiModelProperty(value = "Name of the domain entity", dataType = "java.lang.String", required = true)
	private String entity_name;

	public DomainEntitySimple()
	{
		
	}

	public DomainEntitySimple(Integer id, String entity_name)
	{
		this.id = id;
		this.entity_name = entity_name;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getEntity_name()
	{
		return entity_name;
	}

	public void setEntity_name(String entity_name)
	{
		this.entity_name = entity_name;
	}

}
