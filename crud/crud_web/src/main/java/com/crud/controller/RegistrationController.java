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
	   
	   boolean status=false;
	  
	   if(registerDetails.getEmail() != null && registerDetails.getPassword() != null){
		    status= registerService.saveUser(registerDetails);   
		    return "200";
	   }else{
		    return "404";
	   }
   }
}
