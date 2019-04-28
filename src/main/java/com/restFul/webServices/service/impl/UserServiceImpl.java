package com.restFul.webServices.service.impl;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restFul.webServices.bean.User;
import com.restFul.webServices.exception.UserNotFoundException;
import com.restFul.webServices.repository.UserRepository;
import com.restFul.webServices.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		List<User> lUserList = new ArrayList<>();
		lUserList = userRepository.findAll();
		lUserList.forEach(user -> user.setAge(calculateAge(user.getBirthDay(), LocalDate.now())));
		logger.debug("users found by findAll");
		return lUserList;
	}

	@Override
	public User findById(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		user.setAge(calculateAge(user.getBirthDay(), LocalDate.now()));
		logger.debug("users found by find by id", user);
		return user;
	}

	@Override
	public User save(User user) throws URISyntaxException {
		logger.debug("users save", user);
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Integer id) {
		logger.debug("users delete by id", id);
		userRepository.deleteById(id);
	}

	public Integer calculateAge(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			if (birthDate.getYear() < currentDate.getYear()) {
				logger.debug("age calculate");
				return Period.between(birthDate, currentDate).getYears();
			}
		}
		logger.debug("age not found or 0");
		return 0;
	}

}
