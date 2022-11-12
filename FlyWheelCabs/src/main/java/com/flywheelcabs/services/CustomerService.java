package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Customer;

public interface CustomerService {

	public Customer insertCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(Customer customer) throws CustomerException, LoginException;

	public Customer deleteCustomer(Integer customerId) throws CustomerException, LoginException;

	public List<Customer> getAllCustomers() throws CustomerException, AdminException;

	public Customer getCustomerById(Integer customerId) throws CustomerException, AdminException;

	public Customer getCustomerByMobile(String mobile) throws CustomerException, AdminException;

	public Customer validateCustomer(String userName, String password) throws CustomerException, AdminException;

	public Customer updatePassword(String mobile, String oldPassword, String newPassword)
			throws CustomerException, LoginException;

	public String rateDriver(String mobile, String driverUserName, float rating) throws DriverException, LoginException;

}
