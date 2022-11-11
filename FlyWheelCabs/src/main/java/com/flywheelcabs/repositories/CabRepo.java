package com.flywheelcabs.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.flywheelcabs.modules.Cab;

@Repository
public interface CabRepo extends JpaRepository<Cab, Integer>{

	public List<Cab> findByCarType(String carType);
	
	@Query("select count(cab.carType) from Cab cab where cab.carType=?1")
	public int getcount(String carType);

}
