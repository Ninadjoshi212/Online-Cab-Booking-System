package com.flywheelcabs.services;

import org.springframework.beans.BeanUtils;
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

	@Autowired
	private LoginSessionDao loginDao;

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub

		Customer existingCustomer = cRepo.getCustomerByUsernameAndpassword(customer.getUserName(),
				customer.getPassword());

		if (existingCustomer != null) {
			throw new CustomerException("Customer already exist! Try Login");
		}

		return cRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException, LoginException {

		Optional<LoginSession> sessionStatus = loginDao.findById(customer.getCustomerId());

		if (sessionStatus == null)
			throw new LoginException("Login first to perform this operation!");

		Optional<Customer> optional = cRepo.findById(customer.getCustomerId());

		if (optional.isPresent()) {

			return cRepo.save(customer);
		}

		throw new CustomerException("Customer not found, please register and try again!");

	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException, LoginException {
		// TODO Auto-generated method stub

		Optional<LoginSession> sessionStatus = loginDao.findById(customerId);

		if (sessionStatus == null)
			throw new LoginException("Please login to perform this operation...");

		Optional<Customer> optional = cRepo.findById(customerId);

		if (optional.isPresent()) {
			
			Customer existingCustomer = optional.get();
			
			cRepo.delete(existingCustomer);

			loginDao.deleteById(customerId);

			return existingCustomer;
		
		} else {
			throw new CustomerException("Customer does not exist...");
		}
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerException, AdminException {
		// TODO Auto-generated method stub
		LoginSession sessionStatus = loginDao.findByType("admin");

		if (sessionStatus == null)
			throw new AdminException("Admin not logged in");

		List<Customer> customers = cRepo.findAll();

		if (customers.isEmpty()) {
			throw new CustomerException("No customer in database...");
		}

		return customers;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException, AdminException {
		// TODO Auto-generated method stub

		LoginSession sessionStatus = loginDao.findByType("admin");

		if (sessionStatus == null)
			throw new AdminException("Admin not logged in");

		return cRepo.findById(customerId).orElseThrow(() -> new CustomerException("Customer does not exist..."));
	}

	@Override
	public Customer validateCustomer(String userName, String password) throws CustomerException, AdminException {
		// TODO Auto-generated method stub

		LoginSession sessionStatus = loginDao.findByType("admin");

		if (sessionStatus == null)
			throw new AdminException("Admin not logged in");

		Customer customer = cRepo.getCustomerByUsernameAndpassword(userName, password);

		return customer;
	}

	@Override
	public Customer updatePassword(String mobile, String oldPassword, String newPassword)
			throws CustomerException, LoginException {

		Customer existingCustomer = cRepo.findByMobileAndPassword(mobile, oldPassword);

		if (existingCustomer != null) {

			Optional<LoginSession> sessionStatus = loginDao.findById(existingCustomer.getCustomerId());

			if (sessionStatus == null)
				throw new LoginException("Login first to perform this operation!");

			existingCustomer.setPassword(newPassword);

			return existingCustomer;

		}

		throw new CustomerException("No user registered with mobile " + mobile);

	}

}
