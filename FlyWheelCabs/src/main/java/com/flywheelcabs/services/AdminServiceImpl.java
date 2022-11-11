package com.flywheelcabs.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.modules.TripDetails;
import com.flywheelcabs.repositories.AdminRepo;
import com.flywheelcabs.repositories.CustomerRepo;


@Service
public class AdminServiceImpl implements AdminServices {
	
  @Autowired
	private AdminRepo aRepo;
  
    @Autowired
    private CustomerRepo cRepo;
    
	
	
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

	public List<TripDetails> getAllTrips(Integer customerId) throws AdminException {
		// TODO Auto-generated method stub
		 
			return null;
	}

	@Override
	public List<TripDetails> getTripCabwise() throws AdminException {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripDetails> getTripCustomerwise() throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripDetails> getTripDatewise() throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripDetails> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

 
	
}
