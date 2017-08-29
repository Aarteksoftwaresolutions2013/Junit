package com.crud.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crud.model.Register;
import com.crud.repository.UserRepository;
import com.crud.serviceImpl.UserServiceImpl;
import com.crud.springboot.CrudApp;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CrudApp.class)
@WebMvcTest(UserServiceImpl.class)
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	private Register user;
	@Before
	public void setUp(){
		user = new Register();
		user.setEmail("vicky@gmail.com");
		user.setPassword("1234567");
	}
	
	@Test
	public void test() {
	Register userDetails =  userService.findByEmailAndPassword(user);
	assertEquals("vicky",userDetails.getFirstName());
	}

}
