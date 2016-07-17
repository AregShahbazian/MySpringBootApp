package com.myspingbootapp.controllers;

import org.springframework.web.bind.annotation.*;

import com.myspingbootapp.domain.model.User;
import com.myspingbootapp.persistence.hibernate.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "DomainEntitySimpleEndpoint")
@Api(produces = "application/json")
public class UserController {

	@Autowired
	Environment env;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "Add", method = RequestMethod.POST, produces = { "application/json" })
	@ApiOperation(value = "Add a User to the database", notes = "Not secured", response = ResponseEntity.class)
	public ResponseEntity addUser(@RequestBody User user) {

		Long id = userRepository.save(user);
		return new ResponseEntity(userRepository.getUserById(id), HttpStatus.OK);

	}

}
