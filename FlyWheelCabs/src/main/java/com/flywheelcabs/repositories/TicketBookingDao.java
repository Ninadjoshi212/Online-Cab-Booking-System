package com.flywheelcabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flywheelcabs.modules.TripDetails;

@Repository
public interface TicketBookingDao extends JpaRepository<TripDetails, Integer>{

}
