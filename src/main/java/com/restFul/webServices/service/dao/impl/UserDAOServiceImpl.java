package com.restFul.webServices.service.dao.impl;

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
		}catch (Exception e) {
			logger.error("Impossible de recuperer les users : ", e);
		}
		return userList;
	}
	
	@Override
	public User findById(Integer pId) {
		User lUser = null;
		try {
			lUser = userRepository.findById(pId).orElseThrow(() -> new UserNotFoundException(pId));
		} catch (UserNotFoundException e) {
			logger.error("UserNotFoundException : ", e);
		}catch (Exception e) {
			logger.error("Impossible de recuperer le user : ", e);
		}
		return lUser;
	}

}
