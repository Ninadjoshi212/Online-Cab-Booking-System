package com.flywheelcabs.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.LoginDTO;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.services.LoginService;

@RestController
@RequestMapping("/setting")
public class LoginControll {

	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginSession> userLoginHandler(@Valid @RequestBody LoginDTO logindata) throws Exception{
		
		LoginSession loginSession = loginService.userLoginService(logindata);
		
		return new ResponseEntity<>(loginSession, HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> userLogoutHandler( @RequestParam("key") String key) throws LoginException{
		
		String message = loginService.UserLogoutService(key);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	
}
