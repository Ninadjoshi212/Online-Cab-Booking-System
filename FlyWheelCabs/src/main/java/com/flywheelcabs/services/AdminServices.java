package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.modules.TripDetails;

public interface AdminServices {
   
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	public Admin updateAdmin(Admin admin) throws AdminException;
	public Admin deleteAdminById(Integer adminId) throws AdminException;
	public List<TripDetails> getAllTrips(Integer customerId) throws CustomerException;
	
}
