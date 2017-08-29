package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Register;

public interface RegistrationRepository extends JpaRepository<Register, Integer>{

}
