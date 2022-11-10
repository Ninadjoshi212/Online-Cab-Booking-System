package com.flywheelcabs.controllers;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.services.AdminServices;

@RestController
public class AdminController {
	
  private AdminServices Aservice;
  
  @PostMapping("/admin")
  public ResponseEntity<Admin> saveAdminHandler(@RequestBody Admin admin) throws AdminException{
	  Admin ad=Aservice.insertAdmin(admin);
	  return new ResponseEntity<Admin>(ad,HttpStatus.ACCEPTED);
	  
  }
  @PutMapping("/update")
	public ResponseEntity<Admin> updateEmployee(@RequestBody Admin admin) throws AdminException{

	Admin ad1 = Aservice.updateAdmin( admin);
	return new ResponseEntity<Admin>(ad1,HttpStatus.OK);
	
	}
   
  @DeleteMapping("/admin/{adminId}")
  public ResponseEntity<Admin> deleteEmployeeById(@PathVariable("adminId") Integer adminId)throws AdminException {
	
	Admin adm2=Aservice.deleteAdminById(adminId);
	return new ResponseEntity<Admin>(adm2,HttpStatus.OK);
}
  
  
  
}
