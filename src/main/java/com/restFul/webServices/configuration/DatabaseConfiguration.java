package com.restFul.webServices.configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.restFul.webServices.bean.User;
import com.restFul.webServices.repository.UserRepository;

@Configuration
public class DatabaseConfiguration {

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository ) throws ParseException {
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1996");
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1997");
		Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1998");
		Date date4 = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1999");
		Date date5 = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000");
		
		userRepository.save(new User("User1", date1));
		userRepository.save(new User("User2", date2));
		userRepository.save(new User("User3", date3));
		userRepository.save(new User("User4", date4));
		userRepository.save(new User("User5", date5));
		return null;
	}

}
