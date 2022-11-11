package com.flywheelcabs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.CustomerException;

import java.util.List;
import java.util.Optional;

import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.repositories.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo cRepo;

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub

		Customer existingCustomer = validateCustomer(customer.getUserName(), customer.getPassword());

		if (existingCustomer != null) {
			throw new CustomerException("Customer already exist...");
		}

		Customer newcustomer = new Customer();
		newcustomer.setUserName(customer.getUserName());
		newcustomer.setPassword(customer.getPassword());
		newcustomer.setMobile(customer.getMobile());
		newcustomer.setEmail(customer.getEmail());
		newcustomer.setAddress(customer.getAddress());

		return cRepo.save(newcustomer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Customer existingCustomer = validateCustomer(customer.getUserName(), customer.getPassword());

		if (existingCustomer == null)
			throw new CustomerException("Customer does not exist...");

		return cRepo.save(customer);
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> optional = cRepo.findById(customerId);

		if (optional.isPresent()) {
			Customer existingCustomer = optional.get();
			cRepo.delete(existingCustomer);
			return existingCustomer;
		} else {
			throw new CustomerException("Customer does not exist...");
		}
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> customers = cRepo.findAll();

		if (customers.isEmpty()) {
			throw new CustomerException("No customer in database...");
		}

		return customers;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		return cRepo.findById(customerId).orElseThrow(() -> new CustomerException("Customer does not exist..."));
	}

	@Override
	public Customer validateCustomer(String userName, String password) throws CustomerException {
		// TODO Auto-generated method stub

		Customer customer = cRepo.getCustomerByUsernameAndpassword(userName, password);

		return customer;
	}

}
