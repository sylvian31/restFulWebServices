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
	public List<User> findAll(){
		List<User> userList = new ArrayList<>();
		try {
			userList = userRepository.findAll();
			logger.debug("users found by findAll");
		}catch (Exception e) {
			logger.error("Impossible to get the users : ", e);
		}
		return userList;
	}
	
	@Override
	public User findById(Integer pId) {
		User lUser = null;
		try {
			lUser = userRepository.findById(pId).orElseThrow(() -> new UserNotFoundException(pId));
			logger.debug("user found : " + lUser.getId());
		} catch (UserNotFoundException e) {
			logger.error("User not found : id = " + pId);
		}catch (Exception e) {
			logger.error("Impossible to get the user : ", e);
		}
		return lUser;
	}
	
	@Override
	public User save(User user) throws URISyntaxException {
		return userRepository.save(user);
	}

}
