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
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.modules.Driver;
import com.flywheelcabs.services.DriverService;




@RestController
public class DriverController {

	@Autowired
	private DriverService ds;
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> resgisterDriverHandler(@Valid @RequestBody Driver driver) throws DriverException{
		Driver dr= ds.registerDriver(driver);
		
		return new ResponseEntity<Driver>(dr,HttpStatus.CREATED);
	}
	
	@GetMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> getDriverByIdHandler(@PathVariable("driverId") Integer driverId) throws DriverException{
		Driver dr=ds.viewBestDriver(driverId);
		
		return new ResponseEntity<Driver>(dr,HttpStatus.OK);
	}
	
	@GetMapping("/getalldrivers")
	public ResponseEntity<List<Driver>> getAllEmployeeDetails() throws DriverException{
		List<Driver> dr=ds.getAllDriver();
		
		
		return new ResponseEntity<List<Driver>>(dr,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletedrivers/{driverId}")
	public ResponseEntity<Driver> deleteEmployeeById(@PathVariable("driverId") Integer driverId) throws DriverException{
		
		Driver dr=ds.removeDriver(driverId);
		return new ResponseEntity<Driver>(dr, HttpStatus.OK);
	}
	
	@PutMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> updateEmployee(@PathVariable("driverId") Driver driver) throws DriverException{
		Driver em=ds.updateDriver(driver);
		
		return new ResponseEntity<Driver>(em,HttpStatus.OK);
	}
	
}
