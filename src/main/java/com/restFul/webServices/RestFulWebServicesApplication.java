package com.restFul.webServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.restFul.webServices")
@EnableJpaRepositories("com.restFul.webServices.repository")
public class RestFulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFulWebServicesApplication.class, args);
	}

}
