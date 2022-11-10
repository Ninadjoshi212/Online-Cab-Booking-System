package com.flywheelcabs.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.LoginDTO;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.repositories.LoginSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginSessionDao loginDao;
	

	@Override
	public LoginSession userLoginService(LoginDTO logindata) throws LoginException { //method to check user login or not 
		
		LoginSession currentSession = new LoginSession();
		
		
		String key = RandomString.make(8);
		
		Integer id = (int) (Math.random() + 10);
		
		currentSession.setUserId(id);
		
		currentSession.setUserUniqueId(key);
		
		currentSession.setType("Admin");
		
		currentSession.setLoginTime(LocalDateTime.now());
		
		return loginDao.save(currentSession);
	}

	@Override
	public String UserLogoutService(String Key) throws LoginException {
		
		LoginSession existingSession =  loginDao.findByUserUniqueId(Key);
		
		if(existingSession != null) {
			
			loginDao.delete(existingSession);
			
			return "You have successfully Log out";
			
		}
		
		throw new LoginException("You have already Loged Out");
		
	}

}
