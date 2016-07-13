package com.myspingbootapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * http://stackoverflow.com/questions/25061237/spring-4-addresourcehandlers-not-resolving-the-static-resources
 */

@Configuration
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter
{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}