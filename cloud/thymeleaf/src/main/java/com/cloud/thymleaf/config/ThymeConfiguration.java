package com.cloud.thymleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.RequestContextFilter;

import com.cloud.thymleaf.entity.Person;


@Configuration
public class ThymeConfiguration  extends RequestContextFilter{
	
	@Bean
	public Person createPerson() {
		return new Person();
	}


}
