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
import com.flywheelcabs.modules.AbstractUser;
import com.flywheelcabs.modules.Driver;
import com.flywheelcabs.services.DriverService;
import com.flywheelcabs.*;

@RestController
public class DriverController {

	@Autowired
	private DriverService dService;

	@PostMapping("/drivers")
	public ResponseEntity<Driver> resgisterDriverHandler(@Valid @RequestBody Driver driver) throws DriverException{
		Driver dr=dService.insertDriver(driver);
		
		return new ResponseEntity<Driver>(dr,HttpStatus.CREATED);
	}
	
	@GetMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> getDriverByIdHandler(@PathVariable("driverId") Integer driverId) throws DriverException{
		Driver dr=dService.viewDriver(driverId);
		
		return new ResponseEntity<Driver>(dr,HttpStatus.OK);
	}
	
	@GetMapping("/getalldriverslist")
	public ResponseEntity<List<Driver>> getAllDriverDetails(Integer driverId) throws DriverException{
		List<Driver> emp=dService.getAllDriver(driverId);
		
		
		return new ResponseEntity<List<Driver>>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletedriver/{driverId}")
	public ResponseEntity<Driver> deleteEmployeeById(@PathVariable("driverId") Integer driverId) throws DriverException{
		
		Driver dr=dService.deleteDriver(driverId);
		return new ResponseEntity<Driver>(dr, HttpStatus.OK);
	}
	
	
	@PutMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> updateEmployee(@PathVariable("driverId") Driver driver) throws DriverException{
		Driver dr=dService.updateDriver(driver);
		
		return new ResponseEntity<Driver>(dr,HttpStatus.OK);
	}
	
	
	
}
