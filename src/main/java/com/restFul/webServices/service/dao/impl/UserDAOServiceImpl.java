package com.restFul.webServices.service.dao.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restFul.webServices.bean.User;
import com.restFul.webServices.exception.UserNotFoundException;
import com.restFul.webServices.repository.UserRepository;
import com.restFul.webServices.service.dao.UserDAOService;

@Service
public class UserDAOServiceImpl implements UserDAOService {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		List<User> lUserList = new ArrayList<>();
		lUserList = userRepository.findAll();
		logger.debug("users found by findAll");
		return lUserList;
	}

	@Override
	public User findById(Integer id) {
		User user = null;
		user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		logger.debug("user found : " + user.getId());
		return user;
	}

	@Override
	public User save(User user) throws URISyntaxException {
		return userRepository.save(user);
	}
	
	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

}
