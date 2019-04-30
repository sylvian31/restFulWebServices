package com.restFul.webServices.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException() {
		super("Could not find users");
	}

	public UserNotFoundException(Integer id) {
		super("Could not find user " + id);
	}

}
