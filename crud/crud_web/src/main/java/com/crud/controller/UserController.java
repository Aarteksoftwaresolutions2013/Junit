package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Register;
import com.crud.model.User;
import com.crud.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService UserService ;
	
	@RequestMapping(value = "/user" , method = RequestMethod.POST)
	public Register login(@RequestBody Register user){
		System.out.println("Inside login method of User Controller");
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		
		return UserService.findByEmailAndPassword(user);
				
	}
}
