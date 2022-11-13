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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Driver;
import com.flywheelcabs.services.DriverService;
import com.flywheelcabs.services.LoginService;
import com.flywheelcabs.services.TripServices;



@RequestMapping("/drivers")
@RestController
public class DriverController {

	@Autowired
	private DriverService dservice;
	
	@Autowired
	private LoginService lService;

	@Autowired
	private TripServices tService;
	
	@PostMapping("/register")
	public ResponseEntity<Driver> resgisterDriverHandler(@Valid @RequestBody Driver driver) throws DriverException{
		Driver dr= dservice.registerDriver(driver);
		
		return new ResponseEntity<Driver>(dr,HttpStatus.CREATED);
	}
	
	//### Get single customer using CustomerId
	@GetMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> getDriverByIdHandler(@PathVariable("driverId") Integer driverId) 
			throws DriverException,AdminException{
		Driver dr=dservice.viewBestDriver(driverId);
		
		return new ResponseEntity<Driver>(dr,HttpStatus.OK);
	}
	
	//### Get single Driver using Mobile ###
		@GetMapping("/mobile/{mobileNum}")
		public ResponseEntity<Driver> getDriverByMobileHandler(@PathVariable("mobileNum") String mobile)
				throws DriverException, AdminException {

			Driver fetchedDriver = dservice.getDriverByMobile(mobile);

			return new ResponseEntity<Driver>(fetchedDriver, HttpStatus.OK);
		}

	//### Validate customer ###
		@GetMapping("/validate/{userName}")
		public ResponseEntity<Driver> validateDriverHandler(@PathVariable("userName") String userName,
				@RequestParam("password") String password) throws DriverException, AdminException {

			Driver validatedDriver = dservice.validateDriver(userName, password);

			return new ResponseEntity<Driver>(validatedDriver, HttpStatus.OK);
		}

	//### Get All customer in a List ###
	@GetMapping("/getalldrivers")
	public ResponseEntity<List<Driver>> getAllDriversDetailsHandler() throws DriverException,AdminException{
		List<Driver> dr=dservice.getAllDriver();
		
		
		return new ResponseEntity<List<Driver>>(dr,HttpStatus.OK);
	}
	
	//### Delete Account ###
	@DeleteMapping("/deletedrivers/{driverId}")
	public ResponseEntity<Driver> deleteEmployeeById(@PathVariable("driverId") Integer driverId) 
										throws DriverException,LoginException{
		
		Driver dr=dservice.removeDriver(driverId);
		return new ResponseEntity<Driver>(dr, HttpStatus.OK);
	}
	
	@PutMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> updateDriverHandler(@PathVariable("driverId") Driver driver) 
			throws DriverException,LoginException{
		Driver em=dservice.updateDriver(driver);
		
		return new ResponseEntity<Driver>(em,HttpStatus.OK);
	}
	
	
	//### Update Password of customer ###
		@PutMapping("/customer/update/")
		public ResponseEntity<Driver> updateDriverPassword(@RequestParam("mobile") String mobile,
				@RequestParam("oldpass") String oldpass, @RequestParam("newpass") String newpass)
				throws  LoginException, DriverException {

			Driver updatedDriver = dservice.updatePassword(mobile, oldpass, newpass);

			return new ResponseEntity<Driver>(updatedDriver, HttpStatus.CREATED);

		}
	@GetMapping("/bestdriver/{driverId}/{rating}")
	public List<Driver> getBestDriver(@PathVariable("driverId") Integer driverId,@PathVariable("rating")  float rating) 
			throws DriverException,LoginException{
		
		return dservice.viewBestDriver(driverId,rating);
	}
	
}
