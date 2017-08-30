package com.crud.service;

import com.crud.model.Register;
import com.crud.model.User;

public interface UserService {
    
	/**
	 * *
	 * find by email and password
	 * @param user
	 * @return
	 */
	public boolean findByEmailAndPassword(Register user);
}
