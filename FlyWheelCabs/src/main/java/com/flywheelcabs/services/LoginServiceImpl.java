package com.flywheelcabs.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.controllers.CustomerController;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.modules.Driver;
import com.flywheelcabs.modules.LoginDTO;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.repositories.AdminRepo;
import com.flywheelcabs.repositories.CustomerRepo;
import com.flywheelcabs.repositories.DriverDAO;
import com.flywheelcabs.repositories.LoginSessionDao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginSessionDao loginDao;
	
	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private AdminRepo aRepo;
	
	@Autowired
	private DriverDAO driverDao;
	
	@Override
	public LoginSession userLoginService(LoginDTO logindata) throws LoginException ,Exception {
		
		LoginSession existingSession = loginDao.findByMobile(logindata.getMobileNumber());
		
		if(existingSession != null) {
			throw new LoginException("user already logged in");
		}
		
		Customer existingCustomer = cRepo.findByMobileAndPassword(logindata.getMobileNumber(), logindata.getPassword());
		
		Admin existingAdmin = aRepo.findByMobileAndPassword(logindata.getMobileNumber(), logindata.getPassword());
		
		Driver existingDriver = driverDao.findByMobileAndPassword(logindata.getMobileNumber(), logindata.getPassword());
		
		String type = "";
		Integer userId = null;
		
		if(existingAdmin != null) {
			type = "admin";
			userId = existingAdmin.getAdminId();
		}
		if(existingCustomer != null) {
			type ="customer";
			userId = existingCustomer.getCustomerId();
		}
		
		if(existingDriver != null) {
			type ="driver";
			userId = existingDriver.getDriverId();
		}
		
        
        if(userId == null) throw new Exception("User not registered Yet Please Open a account first");

        LoginSession session = new LoginSession();
        
        session.setLoginTime(LocalDateTime.now());
        session.setType(type);
        session.setUserId(userId);
        session.setMobile(logindata.getMobileNumber());
        String uId = RandomString.make(8);
        session.setUserUniqueId(uId);
		return loginDao.save(session);
        
	}

	@Override
	public String UserLogoutService(String Key) throws LoginException {
		
		LoginSession existingSession =  loginDao.findByUserUniqueId(Key);
		
		if(existingSession != null) {
			
			loginDao.delete(existingSession);
			
			return "You have successfully Log out";
			
		}
		
		throw new LoginException("You have already Logged Out");
		
	}

}
