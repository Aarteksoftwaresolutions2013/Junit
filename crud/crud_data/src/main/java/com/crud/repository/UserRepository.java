package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Register;
import com.crud.model.User;

public interface UserRepository extends JpaRepository<Register, Integer>{

	/**
	 * *
	 * Find user by email and password
	 * @param email
	 * @param password
	 * @return
	 */
	Register findByEmailAndPassword(String email , String password);
}
