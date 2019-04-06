package com.restFul.webServices.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restFul.webServices.bean.User;
import com.restFul.webServices.service.dao.UserDAOService;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDAOService userDAOService;

	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers() {
		return userDAOService.findAll();
	}

	@GetMapping(path = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable Integer id) {
		return userDAOService.findById(id);
	}

	@PostMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createUser(@Valid @RequestBody User user) throws URISyntaxException {
		User savedUser = userDAOService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUserById(@PathVariable Integer id) {
		userDAOService.deleteById(id);
	}
}
