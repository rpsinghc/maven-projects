package com.cloud.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	
	@RequestMapping(value="/*",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> user(){
		return ResponseEntity.ok("{\"token\":\"12345\"}");
	}

}
