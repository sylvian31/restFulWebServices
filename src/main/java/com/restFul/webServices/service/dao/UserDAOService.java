package com.restFul.webServices.service.dao;

import java.util.List;

import com.restFul.webServices.bean.User;

public interface UserDAOService {
	
	public List<User> findAll();
	
	public User findById(Integer pId);

}
