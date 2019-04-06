package com.restFul.webServices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.restFul.webServices.bean.User;
import com.restFul.webServices.service.dao.UserDAOService;

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDAOService userDAOService;

	
	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return userDAOService.findAll();
	}
	
	@GetMapping(path = "user/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userDAOService.findById(id);
	}
}
