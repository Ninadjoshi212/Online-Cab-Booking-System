package com.flywheelcabs.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.AbstractUser;
import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.modules.LoginDTO;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.repositories.LoginSessionDao;
import com.flywheelcabs.services.CustomerService;
import com.flywheelcabs.services.LoginService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LoginSessionDao loginDao;
	
	String mobileNumber = "";
	
	@PostMapping("/customer/login")
	public ResponseEntity<LoginSession> userLoginHandler(@Valid @RequestBody LoginDTO logindata) throws Exception{
		
		mobileNumber = logindata.getMobileNumber();
			LoginSession loginSession = loginService.userLoginService(logindata);
			
			return new ResponseEntity<>(loginSession, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/customer")
	public ResponseEntity<AbstractUser> saveCustomerHandler(@Valid @RequestBody AbstractUser abstractUser)
			throws CustomerException{
 

			AbstractUser newCustomer = cService.insertCustomer(abstractUser);

			return new ResponseEntity<AbstractUser>(newCustomer, HttpStatus.OK);
		
 
	}
	
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException, LoginException {

		LoginSession existingSession = loginDao.findByMobile(mobileNumber);
		
		if(existingSession == null) throw new LoginException("Please Login to update details");
		
		Customer result = cService.updateCustomer(customer);
		
		return  new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	
	
	
	
	
	
}
