package com.crud.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.crud.model.Register;
import com.crud.springboot.CrudApp;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CrudApp.class)
@WebMvcTest(RegistrationController.class)
public class RegistrationConrollerTest {

	@Autowired 
	private RegistrationController registrationController;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Autowired
	private ObjectMapper mapper;
	
	
	private Register registerUserDetails;
	
	@Before
	public void setUp(){
		registerUserDetails = new Register();
		
	}
	
	//Positive Test Case
	@Test
	public void testSaveUser() throws Exception {
		
		registerUserDetails.setContactNumber("1234567891");
		registerUserDetails.setEmail("vicman@gmail.com");
		registerUserDetails.setFirstName("vicky kumar");
		registerUserDetails.setLastName("mandloi");
		registerUserDetails.setPassword("1234567");
		
		String json  = mapper.writeValueAsString(registerUserDetails);
	    ResultActions result =  mockMvc.perform(post("/registerUser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		MvcResult mvcResulet =	result.andReturn();
		MockHttpServletResponse response  = mvcResulet.getResponse();
		
		assertEquals("200", response.getContentAsString());
	}

	//Negative Test Case
	@Test
	public void testSaveUserNotSaved() throws Exception {
		
		registerUserDetails.setContactNumber("1234567891");
		registerUserDetails.setFirstName("v kumar");
		registerUserDetails.setLastName("mandloi");
		registerUserDetails.setPassword("1234567");
		
		String json  = mapper.writeValueAsString(registerUserDetails);
	    ResultActions result =  mockMvc.perform(post("/registerUser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		MvcResult mvcResulet =	result.andReturn();
		MockHttpServletResponse response  = mvcResulet.getResponse();
		
		assertEquals("400", response.getContentAsString());
	}
}
