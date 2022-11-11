package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.modules.Driver;


public interface DriverService {

		public Driver registerDriver(Driver driver) throws DriverException;
		public List<Driver> getAllDriver() throws DriverException;
		public Driver removeDriver(Integer driverId) throws DriverException;
		public Driver updateDriver(Driver driver) throws DriverException;
		
		public Driver viewBestDriver(Integer driverId) throws DriverException;
		
//		public String logoutDriver(String key);
		
		
		
		
}
