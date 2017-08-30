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
	public String login(@RequestBody Register user){
		System.out.println("Inside login method of User Controller");
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		
		boolean userDetails   =  UserService.findByEmailAndPassword(user);
		System.out.println(userDetails);
	    if(userDetails){
	    	return "200";
	    }else{
	    	return "404";
	    }
	}
}
