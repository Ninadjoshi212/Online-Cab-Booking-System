package com.flywheelcabs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.modules.Cab;
import com.flywheelcabs.services.CabServices;


@RestController
public class CabController {

	private CabServices cabService; //cabService taken from service layer
	
	
//	Insert cab presentation layer 
	
	@PostMapping("/insertcab")
	  public ResponseEntity<Cab> insertCabHandler(@RequestBody Cab cab){
		  Cab c=cabService.insertCab(cab);
		  return new ResponseEntity<Cab>(c,HttpStatus.ACCEPTED);
		  
	  }
}
