package com.restFul.webServices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/home")
	public String home (@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("message.home", null, locale);
	}
}
