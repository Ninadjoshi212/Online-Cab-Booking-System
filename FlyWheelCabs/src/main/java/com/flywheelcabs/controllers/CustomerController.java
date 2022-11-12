package com.flywheelcabs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.modules.LoginDTO;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.services.CustomerService;
import com.flywheelcabs.services.LoginService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired
	private LoginService lService;

	@PostMapping("/customer/register")
	public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer)
			throws CustomerException {

		Customer newCustomer = cService.insertCustomer(customer);

		return new ResponseEntity<Customer>(newCustomer, HttpStatus.ACCEPTED);
	}

	@PutMapping("/customer/update")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer)
			throws CustomerException, LoginException {

		Customer updatedCustomer = cService.updateCustomer(customer);

		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable("customerId") Integer customerId)
			throws CustomerException, LoginException {

		Customer deletedCustomer = cService.deleteCustomer(customerId);

		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);

	}

	@GetMapping("/customer/")
	public ResponseEntity<List<Customer>> getAllCustomerHandler() throws CustomerException, AdminException {

		List<Customer> customers = cService.getAllCustomers();

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);

	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable("customerId") Integer customerId)
			throws CustomerException, AdminException {

		Customer fetchedCustomer = cService.getCustomerById(customerId);

		return new ResponseEntity<Customer>(fetchedCustomer, HttpStatus.OK);
	}

	@GetMapping("/customer/validate/{userName}/{password}")
	public ResponseEntity<Customer> validateCustomerHandler(@PathVariable("userName") String userName,
			@PathVariable("password") String password) throws CustomerException, AdminException {

		Customer validatedCustomer = cService.validateCustomer(userName, password);

		return new ResponseEntity<Customer>(validatedCustomer, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/customer/login")
	public ResponseEntity<LoginSession> userLoginHandler(@Valid @RequestBody LoginDTO logindata) throws Exception{
		
		LoginSession loginSession = lService.userLoginService(logindata);
		
		return new ResponseEntity<>(loginSession, HttpStatus.OK);
	}
	
	@GetMapping("/customer/logout")
	public ResponseEntity<String> logoutCustomer(@RequestParam String key) throws CustomerException, LoginException {

		 String status = lService.UserLogoutService(key);
		 
		 return new ResponseEntity<String>(status,HttpStatus.OK);
	}

}
