package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Driver;


public interface DriverService {

		public Driver registerDriver(Driver driver) throws DriverException;
		public List<Driver> getAllDriver() throws DriverException,AdminException;
		public Driver removeDriver(Integer driverId) throws DriverException, LoginException;
		public Driver updateDriver(Driver driver) throws DriverException, LoginException;
		
		public Driver viewBestDriver(Integer driverId) throws DriverException, AdminException;

		public Driver getDriverByMobile(String mobile) throws DriverException, AdminException;

		public Driver validateDriver(String userName, String password) throws DriverException, AdminException;

		public Driver updatePassword(String mobile, String oldPassword, String newPassword)
				throws DriverException, LoginException;
		
		public List<Driver> viewBestDriver(Integer driverId,float rating) throws DriverException, LoginException;
		
//		public String logoutDriver(String key);
		
		
		
		
}
