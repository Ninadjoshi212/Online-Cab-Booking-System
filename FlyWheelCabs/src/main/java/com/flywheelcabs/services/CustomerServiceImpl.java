package com.flywheelcabs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.modules.AbstractUser;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.repositories.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo cRepo;

	
	@Override
	public Customer insertCustomer(AbstractUser abstractUser) throws CustomerException{
		// TODO Auto-generated method stub
		
		Customer existingCustomer = existingCustomer(abstractUser.getEmail(), abstractUser.getMobile());
		
		if (existingCustomer!=null) {
			throw new CustomerException("Customer already exist...");
		}
		
		Customer customer = new Customer();
		customer.setUserName(abstractUser.getUserName());
		customer.setPassword(abstractUser.getPassword());
		customer.setMobile(abstractUser.getMobile());
		customer.setEmail(abstractUser.getEmail());
		customer.setAddress(abstractUser.getAddress());
		
		return cRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException, LoginException {
		Optional<Customer> optional = cRepo.findById(customer.getCustomerId());
		
		if(optional == null) throw new CustomerException("No customer found with Id "+ customer.getCustomerId());
		
		return cRepo.save(customer);
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getAllCustomers(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(Customer customer) throws CustomerException {
  // TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer existingCustomer(String email, String mobile) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer customer=cRepo.getCustomerByEmailAndMobile(email, mobile);
		
		return customer;			
	}

}
