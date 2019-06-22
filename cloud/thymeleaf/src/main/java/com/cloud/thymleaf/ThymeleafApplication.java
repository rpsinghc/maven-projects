package com.cloud.thymleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
public class ThymeleafApplication {

	public static void main(String[] args) {
		try {
			Thread.currentThread();
			Thread.sleep(10000);
		}catch(Exception e) {}
		SpringApplication.run(ThymeleafApplication.class, args);
	}

}
