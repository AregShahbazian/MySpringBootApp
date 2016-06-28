package com.myspingbootapp.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "domain_entity_hierarchical")
@ApiModel(value = "DomainEntityHierarchical", description = "DomainEntityHierarchical description")
public class DomainEntityHierarchical
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;


	@Column(name = "hierarchical_entity_name", nullable = false)
	@Length(max = 20, message = "hierarchical_entity_name can not exceed 20 characters")
	@NotNull(message = "hierarchical_entity_name can not be null")
	@ApiModelProperty(value = "Name of the domain entity", dataType = "java.lang.String", required = true)
	private String hierarchical_entity_name;


	@NotNull(message = "sub_entity_required can not be null")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	@ApiModelProperty(value = "Sub entity (required)", /*dataType = "java.lang.String",*/ required = true)
	private DomainEntitySimple sub_entity_required;

	@NotNull(message = "sub_entity_optional can not be null")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	@ApiModelProperty(value = "Sub entity (optional)", /*dataType = "java.lang.String",*/ required = false)
	private DomainEntitySimple sub_entity_optional;

	public DomainEntityHierarchical()
	{
	}

	public DomainEntityHierarchical(String hierarchical_entity_name, DomainEntitySimple sub_entity_required, DomainEntitySimple sub_entity_optional)
	{
		this.hierarchical_entity_name = hierarchical_entity_name;
		this.sub_entity_required = sub_entity_required;
		this.sub_entity_optional = sub_entity_optional;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getHierarchical_entity_name()
	{
		return hierarchical_entity_name;
	}

	public void setHierarchical_entity_name(String hierarchical_entity_name)
	{
		this.hierarchical_entity_name = hierarchical_entity_name;
	}

	public DomainEntitySimple getSub_entity_required()
	{
		return sub_entity_required;
	}

	public void setSub_entity_required(DomainEntitySimple sub_entity_required)
	{
		this.sub_entity_required = sub_entity_required;
	}

	public DomainEntitySimple getSub_entity_optional()
	{
		return sub_entity_optional;
	}

	public void setSub_entity_optional(DomainEntitySimple sub_entity_optional)
	{
		this.sub_entity_optional = sub_entity_optional;
	}
}
