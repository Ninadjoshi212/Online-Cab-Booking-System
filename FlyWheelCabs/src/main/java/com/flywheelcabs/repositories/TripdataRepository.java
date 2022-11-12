package com.flywheelcabs.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flywheelcabs.modules.TripDetails;

@Repository
public interface TripdataRepository extends JpaRepository<TripDetails, Integer>{

	public List<TripDetails> findByCarType(String carType);

	public List<TripDetails> findByDate(LocalDate ld);
	
	@Query("select t from TripDetails t where t.date between ?1 and ?2 ")
	public List<TripDetails> getAllTripsForDays(LocalDate fromDate ,LocalDate toDate);
}

