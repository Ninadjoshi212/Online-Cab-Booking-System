package com.flywheelcabs.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.modules.AbstractUser;
import com.flywheelcabs.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;

	@PostMapping("/customer")
	public ResponseEntity<AbstractUser> saveCustomerHandler(@Valid @RequestBody AbstractUser abstractUser)
			throws CustomerException {

		AbstractUser newCustomer = cService.insertCustomer(abstractUser);

		return new ResponseEntity<AbstractUser>(newCustomer, HttpStatus.OK);

	}
	
}
