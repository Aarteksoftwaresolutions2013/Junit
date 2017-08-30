package com.crud.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Register;
import com.crud.repository.RegistrationRepository;
import com.crud.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private RegistrationRepository registerRepository;
	
	public boolean saveUser(Register registerDetails) {
         System.out.println("saveUser method of Register service impl");
         if(registerDetails!=null && registerDetails.getEmail() != null && registerDetails.getPassword() != null){
        	 registerRepository.save(registerDetails);
        	 return true;
         }else{
        	 return false;	 
         }
     }

}
