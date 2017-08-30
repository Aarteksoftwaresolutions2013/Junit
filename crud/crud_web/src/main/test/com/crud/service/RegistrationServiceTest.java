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
	}
	
	//Positive Test Case
	@Test
	public void testSaveUser_Success() {
		
		registerUserDetails.setContactNumber("123456");
		registerUserDetails.setEmail("ken@gmail.com");
		registerUserDetails.setFirstName("brother");
		registerUserDetails.setLastName("mandloi");
		registerUserDetails.setPassword("1234567");
		
	  boolean checkRegiseterUser = 	registrationSerivice.saveUser(registerUserDetails) ;
	  System.out.println(checkRegiseterUser);
	  assertEquals(true,checkRegiseterUser);
	}
	
	
	//Negative Test Case
	@Test
	public void testSaveUser_404_WithoutEmailId() {
		
		registerUserDetails.setContactNumber("1234567891");
		registerUserDetails.setFirstName("vicfgfgKumar");
		registerUserDetails.setLastName("mandloi");
		registerUserDetails.setPassword("1234567");
		
	  boolean checkRegiseterUser = 	registrationSerivice.saveUser(registerUserDetails) ;
	  System.out.println(checkRegiseterUser);
	  assertEquals(false,checkRegiseterUser);
	}
	
	@Test
	public void testSaveUser_404_WithoutPassword() {
		
		registerUserDetails.setContactNumber("1234567891");
		registerUserDetails.setEmail("neeraj@gmail.com");
		registerUserDetails.setFirstName("vicfgfgKumar");
		registerUserDetails.setLastName("mandloi");
		
		
	  boolean checkRegiseterUser = 	registrationSerivice.saveUser(registerUserDetails) ;
	  System.out.println(checkRegiseterUser);
	  assertEquals(false,checkRegiseterUser);
	}
	
	@Test
	public void testSaveUser_404_WithoutEmailAndPassword() {
		
		registerUserDetails.setContactNumber("1234567891");
		registerUserDetails.setFirstName("vicfgfgKumar");
		registerUserDetails.setLastName("mandloi");
		
		
	  boolean checkRegiseterUser = 	registrationSerivice.saveUser(registerUserDetails) ;
	  System.out.println(checkRegiseterUser);
	  assertEquals(false,checkRegiseterUser);
	}

}
