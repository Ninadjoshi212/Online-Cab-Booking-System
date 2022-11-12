package com.flywheelcabs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CabException;
import com.flywheelcabs.modules.Cab;
import com.flywheelcabs.services.CabServices;


@RestController
@RequestMapping("/cab")
public class CabController {
	
	@Autowired
	private CabServices cabService; //cabService taken from service layer
	
	
//	Insert cab presentation layer 
	
	@PostMapping("/insertcab")
	  public ResponseEntity<Cab> insertCabHandler(@RequestBody Cab cab) throws AdminException{   //admin exception will be thrown if admin not loggedin
		  
		Cab savedCab =cabService.insertCab(cab);
		
		return new ResponseEntity<Cab>(savedCab,HttpStatus.OK);
		  
	  }
	
//Update cab

	@PostMapping("/updatecab")
	public ResponseEntity<Cab> updateCabHandler(@RequestBody Cab cab) throws CabException, AdminException{		//admin exception will be thrown if admin not loggedin
		
		Cab updatedCab = cabService.updateCab(cab);
		
		return new ResponseEntity<Cab>(updatedCab,HttpStatus.OK);
		
	}

	
//Delete cab	
	
	@DeleteMapping("/deletecab/{cabId}")
	public  ResponseEntity<Cab> deleteCabHandler(@PathVariable("cabId") Integer cabId) throws CabException, AdminException{		//admin exception will be thrown if admin not loggedin
		
		Cab deletedCab = cabService.deleteCab(cabId);
		
		return new ResponseEntity<Cab>(deletedCab,HttpStatus.OK);
	}
	
	
	
//Get cab by car type	
	
	@GetMapping("/getcabsbytype/{carType}")
	public ResponseEntity<List<Cab>> viewCabsOfTypeHandler(@PathVariable("carType") String carType) throws CabException{
		
		List<Cab> cabList = cabService.viewCabsOfType(carType);
		
		return new ResponseEntity<List<Cab>>(cabList,HttpStatus.OK);
		
	}
	
	

//Get count of cabs by car type	
	
	@GetMapping("/countcabsbytype/{carType}")
	public ResponseEntity<Integer> countCabsOfTypeHandler(@PathVariable("carType") String carType) throws CabException{
		
		Integer cabCount = cabService.countCabsOfType(carType);
		
		return new ResponseEntity<Integer>(cabCount,HttpStatus.OK);
		
	}
	
		
	
	
}
