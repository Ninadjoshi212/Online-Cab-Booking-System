package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.CabException;
import com.flywheelcabs.modules.Cab;
import com.flywheelcabs.repositories.CabRepo;

public class CabServiceImpl implements CabServices{

	private CabRepo cabRepo;
	
	@Override
	public Cab insertCab(Cab cab) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cab updateCab(Cab cab) throws CabException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cab deleteCab(Integer cabId) throws CabException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCabsOfType(String carType) throws CabException {
		// TODO Auto-generated method stub
		return 0;
	}

}
