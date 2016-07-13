package com.myspingbootapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Test on
 * http://localhost:8080/mvc/hello?name=Foo
 */


@Controller
@RequestMapping(value = "mvc")
public class SpringMVCController
{

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    
    

}