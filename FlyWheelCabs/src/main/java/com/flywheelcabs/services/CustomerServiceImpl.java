package com.flywheelcabs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.exceptions.LoginException;

import java.util.List;
import java.util.Optional;

import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.modules.Driver;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.repositories.CustomerRepo;
import com.flywheelcabs.repositories.DriverDAO;
import com.flywheelcabs.repositories.LoginSessionDao;

/*
	Business Logic for Customer related methods.
	Will access required data from Data access Layer (CustomerRepo)
	Will provide implementation for the Controller ( endPoints / API calls)
*/

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo cRepo;

	@Autowired
	private LoginSessionDao loginDao;

	@Autowired
	private DriverDAO dRepo;

//### INSERT CUSTOMER ###
	@Override
	public Customer insertCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub

		Customer existingCustomer = cRepo.getCustomerByUsernameAndpassword(customer.getUserName(),
				customer.getPassword());

		if (existingCustomer != null) {
			throw new CustomerException("Customer already exist! Try Login...");
		}

		return cRepo.save(customer);
	}

//### UPDATE CUSTOMER ###
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException, LoginException {

		Optional<LoginSession> sessionStatusCustomer = loginDao.findById(customer.getCustomerId()); // Login status
																									// check

		if (sessionStatusCustomer != null) {

			Optional<Customer> optional = cRepo.findById(customer.getCustomerId());

			if (optional.isPresent()) {

				loginDao.deleteById(customer.getCustomerId());
				return cRepo.save(customer);
				
			}

			throw new CustomerException("Customer not found, please register and try again!");

		}
		throw new LoginException("Please login to perform this operation!");

	}

//### UPDATE PASSWORD ###
	@Override
	public Customer updatePassword(String mobile, String oldPassword, String newPassword)
			throws CustomerException, LoginException {

		LoginSession sessionStatusCustomer = loginDao.findByMobile(mobile); // Login status check

		if (sessionStatusCustomer != null) {

			Customer existingCustomer = cRepo.findByMobileAndPassword(mobile, oldPassword);

			if (existingCustomer != null) {

				existingCustomer.setPassword(newPassword);
				
				loginDao.deleteById(existingCustomer.getCustomerId());

				return existingCustomer;
			}

			throw new CustomerException("Customer not found with mobile " + mobile);

		}
		throw new LoginException("Please login to perform this operation!");

	}

//### DELETE CUSTOMER ###
	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException, LoginException {
		// TODO Auto-generated method stub

		LoginSession sessionStatusAdmin = loginDao.findByType("admin"); // Login status check
		Optional<LoginSession> sessionStatusCustomer = loginDao.findById(customerId); // Login status check

		if (sessionStatusAdmin != null || sessionStatusCustomer.isPresent()) {

			Optional<Customer> optional = cRepo.findById(customerId);

			if (optional.isPresent()) {

				Customer existingCustomer = optional.get();

				cRepo.delete(existingCustomer);

				loginDao.deleteById(customerId);

				return existingCustomer;

			} else {
				throw new CustomerException("Customer does not exist!");
			}

		}
		throw new LoginException("Please login to perform this operation!");

	}

//### GET ALL CUSTOMERS ###
	@Override
	public List<Customer> getAllCustomers() throws CustomerException, AdminException {
		// TODO Auto-generated method stub

		LoginSession sessionStatus = loginDao.findByType("admin"); // Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");

		List<Customer> customers = cRepo.findAll();

		if (customers.isEmpty()) {
			throw new CustomerException("Customer does not exist!");
		}

		return customers;
	}

//### GET CUSTOMER BY ID ###
	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException, AdminException {
		// TODO Auto-generated method stub

		LoginSession sessionStatus = loginDao.findByType("admin"); // Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");

		return cRepo.findById(customerId).orElseThrow(() -> new CustomerException("Customer does not exist..."));
	}

//### GET CUSTOMER BY Mobile ###
	@Override
	public Customer getCustomerByMobile(String mobile) throws CustomerException, AdminException {
		// TODO Auto-generated method stub

		LoginSession sessionStatus = loginDao.findByType("admin"); // Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");

		Customer fetchedCustomer = cRepo.findByMobile(mobile);

		if (fetchedCustomer == null)
			throw new CustomerException("Customer does not exist!");

		return fetchedCustomer;
	}

//### VALIDATE CUSTOMER ###
	@Override
	public Customer validateCustomer(String userName, String password) throws CustomerException, AdminException {
		// TODO Auto-generated method stub

		LoginSession sessionStatus = loginDao.findByType("admin"); // Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");

		Customer customer = cRepo.getCustomerByUsernameAndpassword(userName, password);

		return customer;
	}

//### Rate Driver ###
	@Override
	public String rateDriver(String mobile, String driverUserName, float rating)
			throws DriverException, LoginException {

		String message = "";

		LoginSession sessionStatusCustomer = loginDao.findByMobile(mobile); // Login status check

		if (sessionStatusCustomer != null) {

			Driver driver = dRepo.findByUserName(driverUserName);

			if (driver != null) {

				driver.setRating(rating);
				dRepo.save(driver);
				message = "Driver with username " + driverUserName + " is rated successfully for " + rating;
				return message;

			}

			throw new DriverException("Driver not found with username " + driverUserName);

		}

		throw new LoginException("Please login to perform this operation!");

	}

}
