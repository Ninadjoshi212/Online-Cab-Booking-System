package com.flywheelcabs.services;

import java.time.LocalDateTime;
import java.util.List;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.modules.TripDetails;

public interface AdminServices {
   
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	public Admin updateAdmin(Admin admin) throws AdminException;
	public Admin deleteAdminById(Integer adminId) throws AdminException;
    public List<TripDetails> getAllTrips(Integer customerId) throws AdminException;
	public List<TripDetails> getTripCabwise() throws AdminException;
	public List<TripDetails> getTripCustomerwise() throws AdminException;
	public List<TripDetails> getTripDatewise() throws AdminException;
	public List<TripDetails> getAllTripsForDays(Integer customerId,LocalDateTime fromDate ,LocalDateTime toDate) throws AdminException;

}
