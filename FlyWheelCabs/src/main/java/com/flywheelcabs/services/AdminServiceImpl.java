package com.flywheelcabs.services;

import java.util.List;
import java.util.Optional;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.repositories.AdminRepo;

public class AdminServiceImpl implements AdminServices {
  
	private AdminRepo aRepo;
	
	
	@Override
	public Admin insertAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		Admin ad=aRepo.save(admin);
		return ad;
	}

	@Override
	public Admin updateAdmin(Admin admin)throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> opt=aRepo.findById(admin.getAdminId());
		if(opt.isPresent()) {
			return aRepo.save(admin);
			
		}else {
			throw new AdminException("Invalid Admin details");
		}
	}
	
	@Override
	public Admin deleteAdminById(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> opt=aRepo.findById(adminId);
		if(opt.isPresent()) {
			Admin existingAdmin=opt.get();
			aRepo.delete(existingAdmin);
		  return existingAdmin;	
		}else {
			throw new AdminException("Admin does not exist");
		}
	}

	@Override
	public List<TicketBookingService> getAllTrips(Integer customerId) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<TicketBookingService> getAllTrips(Integer customerId) throws AdminException {
//		// TODO Auto-generated method stub
//		Optional<Admin> tickets= aRepo.findById(customerId);	
//		if(tickets.isEmpty()) {
//			return throw new AdminException("No bookings available");
//		}
//		//List<TicketBookingService> listOfTrips= TicketBookingServiced
//	}
// 

	
}
