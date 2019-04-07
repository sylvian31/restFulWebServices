package com.restFul.webServices.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about the user. ")
public class User {

	@Id
	@GeneratedValue
	@ApiModelProperty(notes="Name should have atleast 2 characters")
	private Integer id;

	@Size(min=2)
	private String name;

	@Past
	@JsonFormat(pattern="dd/MM/yyyy")
	@ApiModelProperty(notes="Birth date should be in the past")
	private Date birthDay;

	public User() {
		
	}

	public User(String name, Date birthDay) {
		super();
		this.name = name;
		this.birthDay = birthDay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

}
