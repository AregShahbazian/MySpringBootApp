package com.myspingbootapp.controllers;

import com.myspingbootapp.domain.dto.DomainEntitySimpleDTO;
import com.myspingbootapp.domain.dto.ValidationErrorDTO;
import com.myspingbootapp.domain.mapping.custom.DomainEntitySimple_DTO2Model_Custom;
import com.myspingbootapp.domain.mapping.mapstruct.DomainEntitySimpleMapper;
import org.springframework.web.bind.annotation.RestController;

import com.myspingbootapp.domain.model.DomainEntitySimple;
import com.myspingbootapp.persistence.IDomainEntityRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "DomainEntitySimpleEndpoint")
@Api(produces = "application/json")
public class DomainEntitySimpleController
{

	@Autowired
	Environment env;

	@Autowired
	IDomainEntityRepository domainEntityRepository;

/*	@Autowired
	DomainEntitySimpleMapper domainEntitySimpleMapper;*/

	@RequestMapping(
			value = "Add",
			method = RequestMethod.POST,
			produces = {"application/json"}
	)
	@ApiOperation(
			value = "Add a DomainEntitySimple object to the database",
			notes = "Not secured",
			response = ResponseEntity.class
	)
	public ResponseEntity addDomainEntitySimple(@RequestBody DomainEntitySimpleDTO domainEntitySimpleDTO)
	{
/*		ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();

		DomainEntitySimple_DTO2Model_Custom domainEntitySimple_dto2Model_custom = new DomainEntitySimple_DTO2Model_Custom();
		DomainEntitySimple domainEntitySimple = domainEntitySimple_dto2Model_custom.map(domainEntitySimpleDTO, validationErrorDTO);

		if (validationErrorDTO.getErrors().size() == 0)
		{
			domainEntityRepository.save(domainEntitySimple);
			return new ResponseEntity<DomainEntitySimple>(domainEntitySimple, HttpStatus.OK);

		}
		else
		{
			return new ResponseEntity<ValidationErrorDTO>(validationErrorDTO, HttpStatus.OK);

		}*/

		DomainEntitySimple domainEntitySimple = DomainEntitySimpleMapper.INSTANCE.domainEntitySimpleDTOToDomainEntitySimple(domainEntitySimpleDTO);
		//DomainEntitySimple domainEntitySimple = domainEntitySimpleMapper.domainEntitySimpleDTOToDomainEntitySimple(domainEntitySimpleDTO);

		return new ResponseEntity<DomainEntitySimple>(domainEntitySimple, HttpStatus.OK);

	}

}
