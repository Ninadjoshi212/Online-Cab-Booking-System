package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Customer;

public interface CustomerService {
	
	//Customer Specific Methods
	public Customer insertCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Customer customer) throws CustomerException;
	
	public List<Customer> getAllCustomers() throws CustomerException;
	
	public Customer getCustomerById()throws CustomerException;
	
	public Customer validateCustomer(String username, String password) throws LoginException;

}
