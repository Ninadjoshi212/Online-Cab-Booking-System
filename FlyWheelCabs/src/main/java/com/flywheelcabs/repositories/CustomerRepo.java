package com.flywheelcabs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.modules.TripDetails;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.userName=?1 AND c.password=?2")
	public Customer getCustomerByUsernameAndpassword(String userName, String password);

	public Customer findByMobileAndPassword(String mobile, String password);
	
	
	Optional<Customer> findByMobile(String mobile);

}
