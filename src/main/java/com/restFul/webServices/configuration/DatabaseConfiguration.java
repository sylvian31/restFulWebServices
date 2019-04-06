package com.restFul.webServices.configuration;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.restFul.webServices.bean.User;
import com.restFul.webServices.repository.UserRepository;

@Configuration
public class DatabaseConfiguration {

	@Bean
	CommandLineRunner initDatabase(UserRepository pUserRepository ) {
		pUserRepository.save(new User("User1", new Date()));
		pUserRepository.save(new User("User2", new Date()));
		pUserRepository.save(new User("User3", new Date()));
		pUserRepository.save(new User("User4", new Date()));
		pUserRepository.save(new User("User5", new Date()));
		return null;
	}

}
