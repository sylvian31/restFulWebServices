package com.restFul.webServices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.restFul.webServices.bean.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("val1", "val2", "val3", "val4", "val5");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);

		return mapping;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveSomeBeans() {
		List<SomeBean> someBeanList = Arrays.asList(new SomeBean("val1", "val2", "val3", "val4", "val5"),
				new SomeBean("val1", "val2", "val3", "val4", "val5"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
		mapping.setFilters(filters);

		return mapping;
	}
}
