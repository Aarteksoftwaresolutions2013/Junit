package com.crud.controller;

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
@WebMvcTest(UserController.class)
public class SpringMvcTestLoginControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private UserController userController;

	@Autowired
	private ObjectMapper mapper;

	private Register register;

	@Before
	public void setUp() {
		register = new Register();
		register.setEmail("shubh@gmail.com");
		register.setPassword("1234567");

	}

	@Test
	public void testUserLogin() throws Exception {

		String json = mapper.writeValueAsString(register);
		ResultActions result = mvc.perform(
				post("/user").contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		MvcResult mvcResult = result.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		System.out.println("................................");
		System.out.println(response.getContentAsString());

	}
}
