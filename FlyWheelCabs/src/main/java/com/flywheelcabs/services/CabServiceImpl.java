package com.flywheelcabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CabException;
import com.flywheelcabs.modules.Cab;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.repositories.CabRepo;
import com.flywheelcabs.repositories.LoginSessionDao;


@Service
public class CabServiceImpl implements CabServices{
	
	@Autowired
	private CabRepo cabRepo;					// entity required to access Cab DAO
	
	@Autowired
	private LoginSessionDao loginDao;			// entity required to check if the admin has logged in
	
	
	
	//Insert cab method implementation	- admin access required
	
	@Override
	public Cab insertCab(Cab cab) throws AdminException {
		
		LoginSession sessionStatus = loginDao.findByType("admin"); // Admin Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");

		
		Cab savedCab = cabRepo.save(cab);
		
		return savedCab;
	}
	
	
	
	// Update cab implementation	- admin access required
	
	@Override
	public Cab updateCab(Cab cab) throws CabException, AdminException {
		
		LoginSession sessionStatus = loginDao.findByType("admin"); // Admin login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");

		
		Optional<Cab> opt= cabRepo.findById(cab.getCabId());
		
		if (opt.isPresent()) {
			
			Cab updatedCab = cabRepo.save(cab);					
			return updatedCab;
			
		} else {
			throw new CabException("Invalid cab details");
		}
		
	}
	
	
	// Delete cab implementation - admin access required

	@Override
	public Cab deleteCab(Integer cabId) throws CabException, AdminException {
		
		LoginSession sessionStatus = loginDao.findByType("admin"); // Admin Login status check

		if (sessionStatus == null)
			throw new AdminException("Admin privileges not available!");

		
		Optional<Cab> opt= cabRepo.findById(cabId);
		
		if(opt.isPresent()) {
			
			Cab existingCab= opt.get();
			cabRepo.delete(existingCab);
			
			return existingCab;
			
		}else
			throw new CabException("Cab does not exist with cabId :"+cabId);
		
	}
	

	// View cabs by type implementation
	
	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabException {

		List<Cab> cabs= cabRepo.findByCarType(carType);
		
		
		if(cabs.size() == 0)
			throw new CabException("No cabs found with car type :"+carType);
		else
			return cabs;
		
	}

	
	// Count of cabs by car type implementation
	
	@Override
	public int countCabsOfType(String carType) throws CabException {
		
		int count = cabRepo.getcount(carType);
		
		if(count== 0)
			throw new CabException("There are no cabs with car type :"+carType);
	
			return count;
	}

}
