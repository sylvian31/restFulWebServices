package com.restFul.webServices.service.dao;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.restFul.webServices.bean.User;

public interface UserDAOService {

	public List<User> findAll();

	public User findById(Integer pId);

	public User save(User user) throws URISyntaxException;

	public void deleteById(Integer pId);

}
