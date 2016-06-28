package com.myspingbootapp.controllers;

import com.myspingbootapp.domain.dto.DomainEntitySimpleDTO;
import com.myspingbootapp.domain.dto.ValidationErrorDTO;
import com.myspingbootapp.domain.mapping.custom.DomainEntitySimple_DTO2Model_Custom;
import com.myspingbootapp.domain.mapping.modelmapper.DomainEntitySimpleModelToDTO;

import org.springframework.web.bind.annotation.RestController;

import com.myspingbootapp.domain.model.DomainEntitySimple;
import com.myspingbootapp.persistence.IDomainEntitySimpleRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "DomainEntitySimpleEndpoint")
@Api(produces = "application/json")
public class DomainEntitySimpleController {

	@Autowired
	Environment env;

	@Autowired
	IDomainEntitySimpleRepository domainEntitySimpleRepository;

	@Autowired
	DomainEntitySimpleModelToDTO domainEntitySimpleModelToDTO;

	@RequestMapping(value = "Add", method = RequestMethod.POST, produces = { "application/json" })
	@ApiOperation(value = "Add a DomainEntitySimple object to the database", notes = "Not secured", response = ResponseEntity.class)
	public ResponseEntity addDomainEntitySimple(@RequestBody DomainEntitySimpleDTO domainEntitySimpleDTO) {
		ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();

		DomainEntitySimple_DTO2Model_Custom domainEntitySimple_dto2Model_custom = new DomainEntitySimple_DTO2Model_Custom();
		DomainEntitySimple domainEntitySimple = domainEntitySimple_dto2Model_custom.map(domainEntitySimpleDTO,
				validationErrorDTO);

		if (validationErrorDTO.getErrors().size() == 0) {
			Integer id = domainEntitySimpleRepository.save(domainEntitySimple);
			return new ResponseEntity(domainEntitySimpleRepository.getDomainEntitySimpleById(id), HttpStatus.OK);

		} else {
			return new ResponseEntity(validationErrorDTO, HttpStatus.OK);

		}

	}

	@RequestMapping(value = "GetById/{id}", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity getById(@PathVariable("id") Integer id) {

		DomainEntitySimple domainEntitySimple = domainEntitySimpleRepository.getDomainEntitySimpleById(id);

		return new ResponseEntity(domainEntitySimple, HttpStatus.OK);

	}

	@RequestMapping(value = "Update", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity update(@RequestBody DomainEntitySimpleDTO domainEntitySimpleDTO) {

		ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();

		DomainEntitySimple_DTO2Model_Custom domainEntitySimple_dto2Model_custom = new DomainEntitySimple_DTO2Model_Custom();
		DomainEntitySimple domainEntitySimple = domainEntitySimple_dto2Model_custom.map(domainEntitySimpleDTO,
				validationErrorDTO);

		if (validationErrorDTO.getErrors().size() == 0) {
			domainEntitySimpleRepository.update(domainEntitySimple);
			return new ResponseEntity(HttpStatus.OK);

		} else {
			return new ResponseEntity(validationErrorDTO, HttpStatus.OK);

		}

	}

	@RequestMapping(value = "Map", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity map(@RequestBody DomainEntitySimpleDTO domainEntitySimpleDTO) {
		System.out.println(domainEntitySimpleDTO.getName());
		
		DomainEntitySimple domainEntitySimple;
		try {
			domainEntitySimple = domainEntitySimpleModelToDTO.convertToEntity(domainEntitySimpleDTO);
			System.out.println(domainEntitySimple.getEntity_name());
			return new ResponseEntity(domainEntitySimple, HttpStatus.OK);
		} catch (ParseException e) {
			return new ResponseEntity(HttpStatus.OK);
		}

	}

}
