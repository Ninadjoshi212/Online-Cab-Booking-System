package com.flywheelcabs.services;

import java.util.List;


import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.modules.Driver;

public interface DriverService {

	public Driver insertDriver(Driver driver) throws DriverException;

	public Driver updateDriver(Driver driver) throws DriverException;

	public Driver deleteDriver(Integer driverId) throws DriverException;
		
	public List<Driver> getAllDriver(Integer driverId) throws DriverException;
				
	public Driver viewDriver(Integer driverid) throws DriverException;
	
	public List<Driver> viewBestDriver(String key,float rating) throws DriverException;
		
	public String logoutDriver(String key) throws DriverException;

}
