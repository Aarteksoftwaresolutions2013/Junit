package com.crud.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Register;
import com.crud.model.User;
import com.crud.repository.UserRepository;
import com.crud.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public boolean findByEmailAndPassword(Register user) {
	   System.out.println(user.getEmail());
	   System.out.println(user.getPassword());
	   Register userDetail  =  userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
	   if(userDetail!=null){
		   return true;
	   }else
	   {
		   return false;
	   }
	
	}

	

}
