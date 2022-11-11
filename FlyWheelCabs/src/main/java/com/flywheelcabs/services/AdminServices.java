package com.flywheelcabs.services;

import java.time.LocalDateTime;
import java.util.List;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.modules.TripDetails;

public interface AdminServices {
   
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin) throws AdminException, LoginException;
	
	public Admin deleteAdminById(Integer adminId) throws AdminException, LoginException;
	
    public List<TripDetails> getAllTrips(Integer customerId) throws AdminException, LoginException,
    CustomerException;
    
	public List<TripDetails> getTripCabwise() throws AdminException;
	
	public List<TripDetails> getTripCustomerwise(Integer customerId) throws AdminException;
	
	public List<TripDetails> getTripDatewise() throws AdminException;
	
	public List<TripDetails> getAllTripsForDays(Integer customerId,LocalDateTime fromDate ,LocalDateTime toDate) throws AdminException;

}
