//package com.flywheelcabs.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.flywheelcabs.exceptions.DriverException;
//import com.flywheelcabs.modules.Driver;
//import com.flywheelcabs.repositories.DriverDAO;
////import com.flywheelcabs.repositories.DriverSessionDao;
//
//
//@Service
//public class DriverServiceImpl implements DriverService {
//
//	@Autowired
//	private DriverDAO driverDao;
//
////	@Autowired
////	private DriverSessionDao driverSessionDao;
//
//	@Override
//	public Driver insertDriver(Driver driver) throws DriverException {
//		Driver ddriver=driverDao.save(driver);
//		if(ddriver!=null) {
//			return ddriver;
//		}
//		else
//		throw new DriverException("Driver detail doesn't exist");
//	}
//
//	@Override
//	public Driver updateDriver(Driver driver) throws DriverException {
//		Optional<Driver> opt=driverDao.findById(driver.getDriverId());
//		if(opt.isPresent()) {
//			 Driver updateDriver=driverDao.save(driver);
//			 return updateDriver;
//		}
//		else
//			throw new DriverException("Invalid Driver Detail");
//	}
//
//	@Override
//	public Driver deleteDriver(Integer driverId) throws DriverException {
//		Optional<Driver> opt=driverDao.findById(driverId);
//		
//		if(opt.isPresent()) {
//			Driver existingemployee=opt.get();
//			driverDao.delete(existingemployee);
//			
//			return existingemployee;
//		}
//		else
//			throw new DriverException("Driver does not exist with this driverId");
//	}
//
//	@Override
//	public List<Driver> viewBestDriver(String key, float rating) throws DriverException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String logoutDriver(String key) throws DriverException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Driver> getAllDriver(Integer driverId) throws DriverException {
//		List<Driver> dr=driverDao.findAll();
//		
//		if(dr.size()==0) {
//			throw new DriverException("No driver detail is there");
//		}
//		else 
//			return dr;
//	}
//
//	@Override
//	public Driver viewDriver(Integer driverid) throws DriverException {
//		return driverDao.findById(driverid).orElseThrow(()-> new DriverException("Invalid Driver id"));
//
//	}
//
//	
//
//	
//	
//	
//}
