package com.mvc.security.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@RequestMapping
public class WebConfig implements WebMvcConfigurer{

	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
	}
}
