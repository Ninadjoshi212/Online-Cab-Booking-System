package com.flywheelcabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.flywheelcabs.modules.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.email=?1 AND c.mobile=?2")
	public Customer getCustomerByEmailAndMobile(String email, String mobile);

}
