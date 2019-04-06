package com.restFul.webServices.exception;

import javassist.NotFoundException;

public class UserNotFoundException extends NotFoundException {

	public UserNotFoundException(Integer pId) {
		super("Could not find user " + pId);
	}

}
