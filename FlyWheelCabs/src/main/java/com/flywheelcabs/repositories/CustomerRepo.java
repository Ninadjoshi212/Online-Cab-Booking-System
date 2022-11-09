package com.flywheelcabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flywheelcabs.modules.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	//DataAccessLayer

}
