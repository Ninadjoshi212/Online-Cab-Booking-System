package com.flywheelcabs.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flywheelcabs.modules.*;
@Repository
public interface DriverDAO extends JpaRepository<Driver, Integer>{

	public Driver findByMobileAndPassword(String mobileNumber,String password);

		@Query("select d from Driver d where d.userName=?1")
		public Driver findByUserName(String userName);
		
		@Query("select d from Driver d where d.userName=?1 AND d.password=?2")
		public Driver getDriverByUsernameAndpassword(String userName, String password);
		
		public Driver findByMobile(String mobile);
		
//		@Query("select * from Driver b  where b.rating>4.5")
		public List<Driver>findByRatingGreaterThan(float r);
		
		
}
