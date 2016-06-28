package com.myspingbootapp.domain.mapping.custom;

import com.myspingbootapp.domain.dto.DomainEntitySimpleDTO;
import com.myspingbootapp.domain.dto.ValidationErrorDTO;
import com.myspingbootapp.domain.model.DomainEntitySimple;

public class DomainEntitySimple_DTO2Model_Custom
{
	public DomainEntitySimple_DTO2Model_Custom()
	{
	}

	public DomainEntitySimple map(DomainEntitySimpleDTO domainEntitySimpleDTO, ValidationErrorDTO validationErrorDTO)
	{

		DomainEntitySimple domainEntitySimple = new DomainEntitySimple();

		if (domainEntitySimpleDTO.getName() != null)
		{
			domainEntitySimple.setEntity_name(domainEntitySimpleDTO.getName());
		}else {
			validationErrorDTO.addValidationError("Entity name must be set");
		}

		return domainEntitySimple;
	}
}
