package com.restFul.webServices.restFulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.restFul.webServices")
public class RestFulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFulWebServicesApplication.class, args);
	}

}
