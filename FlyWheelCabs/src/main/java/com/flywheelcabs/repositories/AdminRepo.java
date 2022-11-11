package com.flywheelcabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flywheelcabs.modules.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
  public Admin findByMobileAndPassword(String mobile, String password);
	
}
