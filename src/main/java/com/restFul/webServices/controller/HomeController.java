package com.restFul.webServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/home")
	public String home() {
		return messageSource.getMessage("message.home", null, LocaleContextHolder.getLocale());
	}
}
