package com.myspingbootapp.domain.mapping.modelmapper;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myspingbootapp.domain.dto.DomainEntitySimpleDTO;
import com.myspingbootapp.domain.model.DomainEntitySimple;
import com.myspingbootapp.persistence.IDomainEntitySimpleRepository;

@Component
public class DomainEntitySimpleModelToDTO {

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	IDomainEntitySimpleRepository domainEntityRepository;
	
	
	public DomainEntitySimpleDTO convertToDto(DomainEntitySimple domainEntitySimple) {
		DomainEntitySimpleDTO domainEntitySimpleDTO = modelMapper.map(domainEntitySimple, DomainEntitySimpleDTO.class);
	    return domainEntitySimpleDTO;
	}
	
	
	public DomainEntitySimple convertToEntity(DomainEntitySimpleDTO domainEntitySimpleDTO) throws ParseException {
		DomainEntitySimple domainEntitySimple = modelMapper.map(domainEntitySimpleDTO, DomainEntitySimple.class);
	    
	    /*if (domainEntitySimpleDTO.getId() != null) {
	    	DomainEntitySimple domainEntitySimpleOld = domainEntityRepository.getDomainEntitySimpleById(domainEntitySimpleDTO.getId());
	    	domainEntitySimple.setId(domainEntitySimpleOld.getId());
	    }*/
	    return domainEntitySimple;
	}
	
}
