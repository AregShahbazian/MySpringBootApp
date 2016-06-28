package com.myspingbootapp.domain.dto;

import com.myspingbootapp.domain.model.DomainEntitySimple;

public class DomainEntityHierarchicalDTO
{
	
	private String hierarchical_entity_name;

	private DomainEntitySimple sub_entity_required;

	private DomainEntitySimple sub_entity_optional;

	public DomainEntityHierarchicalDTO()
	{
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
