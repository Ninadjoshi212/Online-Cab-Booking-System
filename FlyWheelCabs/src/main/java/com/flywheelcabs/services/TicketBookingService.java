package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.BookingException;
import com.flywheelcabs.modules.TripDetails;

public interface TicketBookingService {

	public TripDetails insertTicketDetails(TripDetails ticketDetail) throws BookingException;
	
	public TripDetails updateTicketDetails(TripDetails ticketDetails) throws BookingException;
	
	public TripDetails deleteTicketDetails(Integer tripBookingId) throws BookingException;
	
	public List<TripDetails> getAllTripDetailsOfACustomer(Integer customerId) throws BookingException;
	
	public String getBillofAtrip(Integer customerId) throws BookingException;
	
}
