package com.flywheelcabs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Driver;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.repositories.DriverDAO;
import com.flywheelcabs.repositories.LoginSessionDao;

import java.util.Optional;



/*
Business Logic for Customer related methods.
Will access required data from Data access Layer (CustomerRepo)
Will provide implementation for the Controller ( endPoints / API calls)
*/

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverDAO driverDao;

//	@Autowired
//	DriverSessionDao driverSessionDao;
	
	@Autowired
	private LoginSessionDao loginDao;

	//### INSERT Driver ###
	@Override
	public Driver registerDriver(Driver driver) throws DriverException {
		
		Driver existingDriver = driverDao.getDriverByUsernameAndpassword(driver.getUserName(),
				driver.getPassword());
		if(existingDriver!=null){
			throw new DriverException("Driver already exist! Try Login...");
			
		}
		else 
			return driverDao.save(driver);
			
	}
	//### GET ALL DRIVERS ###
	@Override
	public List<Driver> getAllDriver() throws DriverException,AdminException {
		
		LoginSession sessionStatus = loginDao.findByType("admin"); // Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");
		
		List<Driver> drivers=driverDao.findAll();
		
		if(drivers.size()==0) {
			throw new DriverException("No Driver deatil is there");
		}
		else 
			return drivers;
	}

//### DELETE CUSTOMER ###
	@Override
	public Driver removeDriver(Integer driverId) throws DriverException,LoginException {
		
		LoginSession sessionStatusAdmin = loginDao.findByType("admin"); // Login status check
		Optional<LoginSession> sessionStatusDriver = loginDao.findById(driverId); // Login status check

		if (sessionStatusAdmin != null || sessionStatusDriver.isPresent()) {

			Optional<Driver> optional = driverDao.findById(driverId);

			if (optional.isPresent()) {

				Driver existingDriver = optional.get();

				driverDao.delete(existingDriver);

				loginDao.deleteById(driverId);

				return existingDriver;

			} else {
				throw new DriverException("Driver does not exist!");
			}

		}
		throw new LoginException("Please login to perform this operation!");
	}

	//### UPDATE Driver ###
	@Override
	public Driver updateDriver(Driver driver) throws DriverException, LoginException {
		
		Optional<LoginSession> sessionStatusDriver = loginDao.findById(driver.getDriverId()); // Login status check
		
		if(sessionStatusDriver!=null) {
			
			Optional<Driver> opt=driverDao.findById(driver.getDriverId());
			if(opt.isPresent()) {
				loginDao.deleteById(driver.getDriverId());
				return driverDao.save(driver);
			}
			else
				throw new DriverException("Driver not found, please register and try again!");
		}
		
		throw new LoginException("Please login to perform this operation!");
	}

	//### GET DRIVER BY ID ###
	@Override
	public Driver viewBestDriver(Integer driverId) throws DriverException,AdminException {
		
		LoginSession sessionStatus = loginDao.findByType("admin"); // Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");
		
		return driverDao.findById(driverId).orElseThrow(()-> new DriverException("Driver does not exist..."));
	}

	@Override
	public List<Driver> viewBestDriver(Integer driverId, float rating) throws DriverException {
		Optional<Driver> opt= driverDao.findById(driverId);
		if (opt.isEmpty()) {
			System.out.println("driver is not loged  in");

			throw new DriverException("Driver is not loged in ,Please log in first");
		}

		List<Driver> bestDriver = driverDao.findByRatingGreaterThan(rating);

		return bestDriver;
	}

	//### GET DRIVER BY Mobile ###
	@Override
	public Driver getDriverByMobile(String mobile) throws DriverException, AdminException {
		LoginSession sessionStatus = loginDao.findByType("admin"); // Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");

		Driver fetchedCustomer = driverDao.findByMobile(mobile);

		if (fetchedCustomer == null)
			throw new DriverException("Driver does not exist!");

		return fetchedCustomer;
	}

	//### VALIDATE DRIVER ###
	@Override
	public Driver validateDriver(String userName, String password) throws DriverException, AdminException {
		LoginSession sessionStatus = loginDao.findByType("admin"); // Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");

		Driver driver = driverDao.getDriverByUsernameAndpassword(userName, password);

		return driver;
	}

	//### UPDATE PASSWORD ###
	@Override
	public Driver updatePassword(String mobile, String oldPassword, String newPassword)
			throws DriverException, LoginException {
		LoginSession sessionStatusDriver = loginDao.findByMobile(mobile); // Login status check

		if (sessionStatusDriver != null) {

			Driver existingDriver = driverDao.findByMobileAndPassword(mobile, oldPassword);

			if (existingDriver != null) {

				existingDriver.setPassword(newPassword);
				
				loginDao.deleteById(existingDriver.getDriverId());

				return existingDriver;
			}

			throw new DriverException("Driver not found with mobile " + mobile);

		}
		throw new LoginException("Please login to perform this operation!");
	}

	

	
	

	

}
