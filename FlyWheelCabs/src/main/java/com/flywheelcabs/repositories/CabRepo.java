package com.flywheelcabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flywheelcabs.modules.Cab;

public interface CabRepo extends JpaRepository<Cab, Integer>{

}
