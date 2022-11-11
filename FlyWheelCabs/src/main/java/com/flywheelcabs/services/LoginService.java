package com.flywheelcabs.services;

import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.LoginDTO;
import com.flywheelcabs.modules.LoginSession;


public interface LoginService {
	
	public LoginSession userLoginService(LoginDTO logindata) throws LoginException, Exception;
	
	public String UserLogoutService(String Key) throws LoginException;

}
