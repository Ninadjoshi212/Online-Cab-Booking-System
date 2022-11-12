package com.flywheelcabs.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flywheelcabs.modules.TripDetails;

@Repository
public interface TripdataRepository extends JpaRepository<TripDetails, Integer>{

	public List<TripDetails> findByCarType(String carType);
	public List<TripDetails> findByCustomerId(Integer customerId);
	public List<TripDetails> findByDate(LocalDate date);
	
	@Query("select t from TripDetails t where t.customerId=?1 and t.date between ?2 and ?3 ")
	public List<TripDetails> getAllTripsForDays(Integer customerId,LocalDate fromDate ,LocalDate toDate);
}

