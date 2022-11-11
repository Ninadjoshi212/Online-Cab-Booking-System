package com.flywheelcabs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.modules.Driver;
import com.flywheelcabs.repositories.DriverDAO;

import java.util.Optional;








@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverDAO driverDao;

//	@Autowired
//	DriverSessionDao driverSessionDao;

	@Override
	public Driver registerDriver(Driver driver) throws DriverException {
		Driver dr=driverDao.save(driver);
		if(dr!=null){
			return dr;
		}
		else 
			throw new DriverException("Driver not found");
	}

	@Override
	public List<Driver> getAllDriver() throws DriverException {
		List<Driver> dr=driverDao.findAll();
		
		if(dr.size()==0) {
			throw new DriverException("No Driver deatil is there");
		}
		else 
			return dr;
	}

	@Override
	public Driver removeDriver(Integer driverId) throws DriverException {
		Optional<Driver> opt=driverDao.findById(driverId);
		
		if(opt.isPresent()) {
			Driver existingdriver=opt.get();
			driverDao.delete(existingdriver);
			
			return existingdriver;
		}
		else
			throw new DriverException("Driver does not exist with this driverId");
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverException {
		Optional<Driver> opt=driverDao.findById(driver.getDriverId());
		if(opt.isPresent()) {
			 Driver updateDriver=driverDao.save(driver);
			 return updateDriver;
		}
		else
			throw new DriverException("Invalid Driver Detail");
	}

	@Override
	public Driver viewBestDriver(Integer driverId) throws DriverException {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

	

}
