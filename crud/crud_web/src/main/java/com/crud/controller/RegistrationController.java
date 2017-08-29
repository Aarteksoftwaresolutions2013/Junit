package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Register;
import com.crud.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registerService;
	
	@RequestMapping(value="/registerUser" , method=RequestMethod.POST)
   public String saveUser(@RequestBody Register registerDetails){
	   System.out.println("Inside saveuser() method of registeration controller");
	   System.out.println(registerDetails.getFirstName());
	   System.out.println(registerDetails.getLastName());
	   System.out.println(registerDetails.getContactNumber());
	   System.out.println(registerDetails.getEmail());
	   System.out.println(registerDetails.getPassword());
	   
	   boolean status= registerService.saveUser(registerDetails);
	   if(status){
		   return "200";
	   }else{
		   return "400";
	   }
   }
}
