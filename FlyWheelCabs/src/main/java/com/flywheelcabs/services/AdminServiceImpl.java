package com.flywheelcabs.services;

import com.flywheelcabs.modules.Admin;
import com.flywheelcabs.repositories.AdminRepo;

public class AdminServiceImpl implements AdminServices {
  
	private AdminRepo aRepo;
	
	@Override
	public Admin insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin ad=aRepo.save(admin);
		return ad;
	}

}
