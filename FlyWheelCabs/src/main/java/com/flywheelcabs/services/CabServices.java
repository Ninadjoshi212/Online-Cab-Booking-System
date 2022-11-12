package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CabException;
import com.flywheelcabs.modules.Cab;


public interface CabServices {
	
	public Cab insertCab(Cab cab) throws AdminException;
	
	public Cab updateCab(Cab cab) throws CabException, AdminException;
	
	public  Cab deleteCab(Integer cabId) throws CabException, AdminException;
	
	public List<Cab> viewCabsOfType(String carType) throws CabException;
	
	public int countCabsOfType(String carType) throws CabException;
		
}
