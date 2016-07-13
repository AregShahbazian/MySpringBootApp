package com.myspingbootapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "ng")
public class AngularJSController
{

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello()
	{
		return "ng/hello";
	}


}