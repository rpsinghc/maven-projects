package com.otrs.resturant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineTableReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTableReservationApplication.class, args);
	}

}
