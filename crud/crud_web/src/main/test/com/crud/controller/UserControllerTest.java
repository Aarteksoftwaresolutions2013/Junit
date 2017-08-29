package com.crud.controller;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.crud.model.Register;
import com.crud.model.User;
import com.crud.springboot.CrudApp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CrudApp.class)
@TransactionConfiguration(defaultRollback = false)
@Transactional

public class UserControllerTest {

	@Autowired
	private UserController userController;
	
	private Register user ;
	
	@Before
	public void setUp(){
		user = new Register();
		user.setEmail("vicky@gmail.com");
		user.setPassword("1234567");
	}
	
	@Test
	public void test() {
		Register checkUser  = userController.login(user);
		assertEquals("vicky",checkUser.getFirstName());
	}

}
