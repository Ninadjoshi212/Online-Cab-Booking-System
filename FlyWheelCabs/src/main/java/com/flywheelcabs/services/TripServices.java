package com.flywheelcabs.services;

import java.util.List;

import com.flywheelcabs.exceptions.BookingException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Invoice;
import com.flywheelcabs.modules.TripDetailDTO;
import com.flywheelcabs.modules.TripDetails;

public interface TripServices {

	public TripDetails insertTicketDetails(TripDetailDTO ticketDetail) throws BookingException, LoginException, CustomerException, DriverException;
	
	public TripDetails updateTicketDetails(TripDetailDTO ticketDetails,  Integer tripBookedId) throws BookingException, LoginException;
	
	public TripDetails deleteTicketDetails(Integer tripBookingId) throws BookingException, LoginException;
	
	public List<TripDetails> getAllTripDetailsOfACustomer(Integer customerId) throws BookingException, CustomerException, LoginException;
	
	public Invoice getInvoiceDetails(Integer customerId) throws BookingException, CustomerException, LoginException;
	
}
