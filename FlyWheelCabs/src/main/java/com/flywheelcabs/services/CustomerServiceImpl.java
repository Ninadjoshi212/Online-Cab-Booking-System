package com.flywheelcabs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.repositories.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	// Service Layer

	// Customer Repository dependency
	private CustomerRepo custRepo;

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer validateCustomer(String username, String password) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

}
