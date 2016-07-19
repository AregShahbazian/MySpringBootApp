package com.myspingbootapp.controllers;

import org.springframework.web.bind.annotation.*;

import com.myspingbootapp.domain.model.User;
import com.myspingbootapp.persistence.repositories.GenericRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping(value = "User")
@Api(produces = "application/json")
@Transactional
public class UserController {

	@Autowired
	Environment environment;

	@Autowired
	GenericRepository genericRepository;

	@RequestMapping(value = "Add", method = RequestMethod.POST, produces = { "application/json" })
	@ApiOperation(value = "Add a User to the database", notes = "Not secured", response = ResponseEntity.class)
	public ResponseEntity addUser(@RequestBody User userInput) {

		Long id = genericRepository.save(userInput);
		
		User user = genericRepository.getObjectById(id, User.class);

		return new ResponseEntity(user, HttpStatus.OK);
	}

	@RequestMapping(value = "Get/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ApiOperation(value = "Get a User from the database, using the id", notes = "Not secured", response = ResponseEntity.class)
	public ResponseEntity getUser(@PathVariable("id") Long id) {

		User user = genericRepository.getObjectById(id, User.class);

		return new ResponseEntity(user, HttpStatus.OK);

	}

}
