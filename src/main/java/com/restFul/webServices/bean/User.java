package com.restFul.webServices.bean;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All details about the user. ")
public class User {

	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "Name should have atleast 2 characters")
	private Integer id;

	@Size(min = 2)
	private String name;

	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty(notes = "Birth date should be in the past")
	private LocalDate birthDay;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Post> posts;
	
	private Integer age;

	public User() {

	}

	public User(String name, LocalDate birthDay) {
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

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
