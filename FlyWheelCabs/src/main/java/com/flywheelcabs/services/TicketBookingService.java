package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.BookingException;
import com.flywheelcabs.modules.TripDetailDTO;
import com.flywheelcabs.modules.TripDetails;

public interface TicketBookingService {

	public TripDetails insertTicketDetails(TripDetailDTO ticketDetail) throws BookingException;
	
	public TripDetails updateTicketDetails(TripDetailDTO ticketDetails,  Integer tripBookedId) throws BookingException;
	
	public TripDetails deleteTicketDetails(Integer tripBookingId) throws BookingException;
	
	public List<TripDetails> getAllTripDetailsOfACustomer(Integer customerId) throws BookingException;
	
	public String getBilloftrip(Integer customerId) throws BookingException;
	
}
