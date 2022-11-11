package com.flywheelcabs.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Driver> resgisterEmployeeHandler(@Valid @RequestBody Driver driver) throws DriverException{
		Driver dr= ds.registerDriver(driver);
		
		return new ResponseEntity<Driver>(dr,HttpStatus.CREATED);
	}
	
//	@GetMapping("/employees/{empid}")
//	public ResponseEntity<Employee> getEmployeeByIdHandler(@PathVariable("empid") Integer empId) throws EmployeeException{
//		Employee emp=es.getEmployeeById(empId);
//		
//		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
//	}
//	
//	@GetMapping("/getallemployees")
//	public ResponseEntity<List<Employee>> getAllEmployeeDetails() throws EmployeeException{
//		List<Employee> emp=es.getAllEmployeeDetails();
//		
//		
//		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/deleteemployees/{empid}")
//	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("empid") Integer empId) throws EmployeeException{
//		
//		Employee emp=es.deleteEmployeeById(empId);
//		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
//	}
//	
//	@GetMapping("/getemployeebyaddress/address")
//	public ResponseEntity<List<Employee>>  getEmployeeDetailsByAddress(@PathVariable("address") String address) throws EmployeeException{
//		
//		List<Employee> list=es.getEmployeeDetailsByAddress(address);
//		
//		return new ResponseEntity<List<Employee>>(list,HttpStatus.ACCEPTED);
//	}
//	
//	@PutMapping("/employees/{empid}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable("empid") Employee emp) throws EmployeeException{
//		Employee em=es.updateEmployee(emp);
//		
//		return new ResponseEntity<Employee>(em,HttpStatus.OK);
//	}
//	
//	@GetMapping("/getnameaddess/empid")
//	public ResponseEntity<List<String>> getNameAndAddressOfEmplyeeById(@PathVariable("empid") Integer empId) throws EmployeeException{
//		String result=es.getNameAndAddressOfEmplyeeById(empId);
//		
//		return new ResponseEntity<List<String>>(HttpStatus.OK);
//	}
//	
//	@GetMapping("/getnameAddressSalary")
//	public ResponseEntity<List<EmployeeDTO>> getNameAddressSalaryOfAllEmployee() throws EmployeeException{
//		List<EmployeeDTO> led=es.getNameAddressSalaryOfAllEmployee();
//		
//		return new ResponseEntity<List<EmployeeDTO>>(led,HttpStatus.OK);
//		
//	}
}
