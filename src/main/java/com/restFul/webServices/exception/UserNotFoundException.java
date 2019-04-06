package com.restFul.webServices.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(Integer pId) {
		super("Could not find user " + pId);
	}

}
