package com.restFul.webServices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restFul.webServices.versioning.Name;
import com.restFul.webServices.versioning.PersonV1;
import com.restFul.webServices.versioning.PersonV2;

@RestController
public class PersonVersioningController {

	@GetMapping(path = "/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("sylvian");
	}

	@GetMapping(path = "/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("sylvian", "caron"));
	}

	@GetMapping(path = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("sylvian");
	}

	@GetMapping(path = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("sylvian", "caron"));
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("sylvian");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("sylvian", "caron"));
	}
	
	@GetMapping(path="/person/produces", produces = "application/com.restFul.webServices-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("sylvian");
	}
	
	@GetMapping(path="/person/produces", produces = "application/com.restFul.webServices-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("sylvian", "caron"));
	}
}
