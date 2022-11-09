package com.flywheelcabs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.services.AdminServices;

@RestController
public class AdminController {
	
  private AdminServices Aservice;
  
  @PostMapping("/admin")
  public ResponseEntity<Admin> saveAdminHandler(@RequestBody Admin admin){
	  Admin ad=Aservice.insertAdmin(admin);
	  return new ResponseEntity<Admin>(ad,HttpStatus.ACCEPTED);
	  
  }
  
  
  
}
