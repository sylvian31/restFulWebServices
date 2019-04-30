package com.restFul.webServices.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.restFul.webServices.bean.User;
import com.restFul.webServices.repository.UserRepository;
import com.restFul.webServices.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService = new UserServiceImpl();

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCalculateAge_Success() {
		LocalDate birthDate = LocalDate.of(1961, 5, 17);
		LocalDate CurrentDay = LocalDate.of(2019, 4, 25);
		Integer age = userService.calculateAge(birthDate, CurrentDay);
		Assert.assertEquals(new Integer(57), age);
	}

	@Test
	public void testCalculateAgeWrondDate_Success() {
		LocalDate birthDate = LocalDate.of(2025, 5, 17);
		LocalDate CurrentDay = LocalDate.of(2019, 4, 25);
		Integer age = userService.calculateAge(birthDate, CurrentDay);
		Assert.assertEquals(new Integer(0), age);
	}

	@Test()
	public void testSaveUser() throws URISyntaxException {
		doReturn(generateUser()).when(userRepository).save(any(User.class));
		User user = userService.save(generateUser());
		Assert.assertEquals(user.getId(), new Integer(10001));
		Assert.assertEquals(user.getName(), "sylvian");
		Assert.assertEquals(user.getBirthDay(), LocalDate.of(1961, 5, 17));
	}

	@Test
	public void testFindUser() {
		doReturn(Optional.of(generateUser())).when(userRepository).findById(any(Integer.class));
		User user = userService.findById(10001);
		Assert.assertEquals(user.getId(), new Integer(10001));
		Assert.assertEquals(user.getName(), "sylvian");
		Assert.assertEquals(user.getBirthDay(), LocalDate.of(1961, 5, 17));
	}

	private User generateUser() {
		User user = new User();
		user.setId(10001);
		user.setName("sylvian");
		user.setBirthDay(LocalDate.of(1961, 5, 17));
		return user;
	}
}
