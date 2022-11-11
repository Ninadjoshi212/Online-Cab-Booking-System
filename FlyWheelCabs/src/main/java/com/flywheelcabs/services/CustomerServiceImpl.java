package com.flywheelcabs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.LoginException;

import java.util.List;
import java.util.Optional;

import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.repositories.CustomerRepo;
import com.flywheelcabs.repositories.LoginSessionDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo cRepo;
	
//	@Autowired
//	private LoginSessionDao loginDao;

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
	public Customer updateCustomer(Customer customer) throws CustomerException, LoginException {
//		
//		Optional<LoginSession> existingSession = loginDao.findById(customer.getCustomerId());
//		
//		if(existingSession == null) throw new LoginException("Please login to update your data");
//		
//		Optional<Customer> optional = cRepo.findById(customer.getCustomerId());
//		
//		if(optional.isPresent()) {
//			return cRepo.save(customer);
//		}
//		throw new CustomerException("customer not found");
		
		Customer existingCustomer = validateCustomer(customer.getUserName(), customer.getPassword()); //

		if (existingCustomer == null)
			throw new CustomerException("Customer does not exist...");

		return cRepo.save(customer);
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		
//		Optional<LoginSession> existingSession = loginDao.findById(customer.getCustomerId());
//		
//		if(existingSession == null) throw new LoginException("Please login to update your data");
		
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
	public List<Customer> getAllCustomers() throws CustomerException, AdminException {
		// TODO Auto-generated method stub
//		LoginSession adminSession =  loginDao.findByType("admin");
//		
//		if(adminSession == null) throw new AdminException("Admin not logged in");
		
		List<Customer> customers = cRepo.findAll();

		if (customers.isEmpty()) {
			throw new CustomerException("No customer in database...");
		}

		return customers;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		

//		LoginSession adminSession =  loginDao.findByType("admin");
//		
//		if(adminSession == null) throw new AdminException("Admin not logged in");
		
		
		return cRepo.findById(customerId).orElseThrow(() -> new CustomerException("Customer does not exist..."));
	}

	@Override
	public Customer validateCustomer(String userName, String password) throws CustomerException {
		// TODO Auto-generated method stub
		

//		LoginSession adminSession =  loginDao.findByType("admin");
//		
//		if(adminSession == null) throw new AdminException("Admin not logged in");
		

		Customer customer = cRepo.getCustomerByUsernameAndpassword(userName, password);

		return customer;
	}

}
