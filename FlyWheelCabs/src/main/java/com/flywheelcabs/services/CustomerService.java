package com.flywheelcabs.services;

import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.modules.AbstractUser;
import com.flywheelcabs.modules.Customer;

public interface CustomerService {

	public Customer insertCustomer(AbstractUser abstractUser) throws CustomerException;

	public Customer updateCustomer(Customer customer) throws CustomerException;

	public Customer deleteCustomer(Customer customer) throws CustomerException;

	public Customer getAllCustomers(Customer customer) throws CustomerException;

	public Customer getCustomerById(Customer customer) throws CustomerException;

	public Customer existingCustomer(String email, String mobile) throws CustomerException;

}
