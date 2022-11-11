package com.flywheelcabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.CabException;
import com.flywheelcabs.modules.Cab;
import com.flywheelcabs.repositories.CabRepo;


@Service
public class CabServiceImpl implements CabServices{
	
	@Autowired
	private CabRepo cabRepo;
	
	@Override
	public Cab insertCab(Cab cab) {
		
		Cab savedCab = cabRepo.save(cab);
		
		return savedCab;
	}
	
	

	@Override
	public Cab updateCab(Cab cab) throws CabException {
		
		Optional<Cab> opt= cabRepo.findById(cab.getCabId());
		
		if (opt.isPresent()) {
			
			Cab updatedCab = cabRepo.save(cab);
			return updatedCab;
			
		} else {
			throw new CabException("Invalid cab details");
		}
		
	}
	

	@Override
	public Cab deleteCab(Integer cabId) throws CabException {
		
		Optional<Cab> opt= cabRepo.findById(cabId);
		
		if(opt.isPresent()) {
			
			Cab existingCab= opt.get();
			cabRepo.delete(existingCab);
			
			return existingCab;
			
		}else
			throw new CabException("Cab does not exist with cabId :"+cabId);
		
	}
	

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabException {

		List<Cab> cabs= cabRepo.findByCarType(carType);
		
		
		if(cabs.size() == 0)
			throw new CabException("No cabs found with car type :"+carType);
		else
			return cabs;
		
	}

	
	@Override
	public int countCabsOfType(String carType) throws CabException {
		
		List<Cab> cabs= cabRepo.findByCarType(carType);
		
		if(cabs.size() == 0)
			throw new CabException("There are no cabs with car type :"+carType);
		else
			return cabs.size();
	}

}
