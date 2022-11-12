package com.flywheelcabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.flywheelcabs.modules.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.userName=?1 AND c.password=?2")
	public Customer getCustomerByUsernameAndpassword(String userName, String password);

	public Customer findByMobileAndPassword(String mobile, String password);

	public Customer findByMobile(String mobile);

}
