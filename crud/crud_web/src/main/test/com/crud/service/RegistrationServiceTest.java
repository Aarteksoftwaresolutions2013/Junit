package com.crud.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crud.model.Register;
import com.crud.serviceImpl.RegistrationServiceImpl;
import com.crud.springboot.CrudApp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CrudApp.class)
@WebMvcTest(RegistrationServiceImpl.class)
public class RegistrationServiceTest {

	@Autowired
	RegistrationService registrationSerivice ;
	

	private Register registerUserDetails; 
	
	@Before
	public void setUp(){
		registerUserDetails = new Register();
		registerUserDetails.setContactNumber("1234567891");
		registerUserDetails.setEmail("v@gmail.com");
		registerUserDetails.setFirstName("vicky kumar");
		registerUserDetails.setLastName("mandloi");
		registerUserDetails.setPassword("1234567");
	}
	
	@Test
	public void test() {
	  boolean checkRegiseterUser = 	registrationSerivice.saveUser(registerUserDetails) ;
	  assertEquals(true,checkRegiseterUser);
	}

}
