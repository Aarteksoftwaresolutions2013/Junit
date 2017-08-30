package com.crud.repository;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

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
@TransactionConfiguration(defaultRollback = true)
@Transactional

public class UserRepoTest {

	@Autowired
	private UserRepository userRepository;
	
	/*.........Positive case.......*/
	@Test
	public void testFindByEmailPasswors() {
	 Register user = userRepository.findByEmailAndPassword("shubh@gmail.com", "1234567");
	 assertEquals("9713707037", user.getContactNumber());
	}
	
	/*.........Negative case.......*/
	@Test
	public void testFindByEmailPasswordNotFound(){
		 Register user = userRepository.findByEmailAndPassword("shubh@gmail.com", "123");
		 assertNull(user);
	}
}
