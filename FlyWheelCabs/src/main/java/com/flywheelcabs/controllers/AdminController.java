package com.flywheelcabs.controllers;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.BookingException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.modules.TripDetails;
import com.flywheelcabs.services.AdminServices;

@RestController
public class AdminController {
  

@Autowired
  private AdminServices aService;

  
   //save admin
  @PostMapping("/admin")
  public ResponseEntity<Admin> saveAdminHandler(@RequestBody Admin admin) throws AdminException{
	  Admin ad=aService.insertAdmin(admin);
	  return new ResponseEntity<Admin>(ad,HttpStatus.ACCEPTED);
	  
  }
  //Admin update
  @PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) throws AdminException, LoginException{

	Admin ad1 = aService.updateAdmin( admin);
	return new ResponseEntity<Admin>(ad1,HttpStatus.OK);
	
	}
  
  
   
  //delete admin by adminId
  @DeleteMapping("/admin/{adminId}")
  public ResponseEntity<Admin> deleteEmployeeById(@PathVariable("adminId") Integer adminId)throws AdminException, LoginException {
	
	Admin adm2=aService.deleteAdminById(adminId);
	return new ResponseEntity<Admin>(adm2,HttpStatus.OK);
}
  
  
  
  @GetMapping("/alltripsbycustomerid/{customerId}")
  public ResponseEntity<List <TripDetails>> getAllTripsByCustomerId(@PathVariable("customerId") Integer customerId) throws AdminException, LoginException, CustomerException{
	  List<TripDetails> list=aService.getAllTrips(customerId);
	  return new ResponseEntity<List<TripDetails>>(list,HttpStatus.OK);
  }
  
  
  
  @GetMapping("/getTripcabwise/{carType}")
  public ResponseEntity<List <TripDetails>> getTripcabwise(@PathVariable("carType") String carType) throws AdminException, LoginException, CustomerException, BookingException{
	  List<TripDetails> list=aService.getTripCabwise(carType);
	  return new ResponseEntity<List<TripDetails>>(list,HttpStatus.OK);
  } 
  
  @GetMapping("/tripByDate/{date}")
  public ResponseEntity<List<TripDetails>> getTripByDate(@PathVariable("date")String date) throws AdminException, CustomerException, ParseException, LoginException{
	  List<TripDetails> list=aService.getTripDatewise(date);
	  return new ResponseEntity<List<TripDetails>>(list,HttpStatus.OK);
	  
  }
  
  
  @GetMapping("/getTripForDays/{sDate}/{eDate}")
  public ResponseEntity<List <TripDetails>> getTripForDays(@PathVariable("sDate") LocalDate fromDate, @PathVariable("eDate")LocalDate toDate) throws AdminException, LoginException, CustomerException, BookingException{
	  List<TripDetails> list=aService.getAllTripsForDays(fromDate,toDate);
	  return new ResponseEntity<List<TripDetails>>(list,HttpStatus.OK);
  }
  
  
}
