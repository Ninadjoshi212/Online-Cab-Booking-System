package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.modules.Admin;

public interface AdminServices {
   
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	public Admin updateAdmin(Admin admin) throws AdminException;
	public Admin deleteAdminById(Integer adminId) throws AdminException;
	public List<TicketBookingService> getAllTrips(Integer customerId) throws AdminException;
	
}
