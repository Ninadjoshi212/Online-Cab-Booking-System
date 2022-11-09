package com.flywheelcabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.BookingException;
import com.flywheelcabs.modules.TripDetails;
import com.flywheelcabs.repositories.TicketBookingDao;

/*
 This is the Service layer. All API call for ticket booking or a tripBooking are handle and
 It contains business or service logics for booking a ticket or respected operations.
 */


@Service
public class TicketBookingServiceImpl  implements TicketBookingService{

	@Autowired
	private TicketBookingDao ticketDao; // Dao Interface of ticketBooking for calling respective repository methods.
	
	
	@Override
	public TripDetails insertTicketDetails(TripDetails ticketDetail) throws BookingException { //This method handle the Insertion of a booked ticket details
		
		if(ticketDetail == null) throw new BookingException("Please select aTicket");
		
		return ticketDao.save(ticketDetail);
	}

	@Override
	public TripDetails updateTicketDetails(TripDetails ticketDetails) throws BookingException { // This method used to update any booked ticket
		
		Optional<TripDetails> optional = ticketDao.findById(ticketDetails.getTripBookingId());
		
		if(optional.isPresent()) {
			
			
			return ticketDao.save(ticketDetails);
			
		}
		throw new BookingException("No cab booked with bookingId "+ticketDetails.getTripBookingId()); 
		
	}

	@Override
	public TripDetails deleteTicketDetails(Integer tripBookingId) throws BookingException { // for canceling or deleting a trip or ride 
		
		Optional<TripDetails> optional = ticketDao.findById(tripBookingId);
		
		if(optional.isPresent()) {
			
			TripDetails existingTicket = optional.get();
			
			ticketDao.delete(existingTicket);
			
			return existingTicket;
			
		}
		
		throw new BookingException("No ticket booked with tripBookingId "+tripBookingId);
		
	}

	@Override
	public List<TripDetails> getAllTripDetailsOfACustomer(Integer customerId) throws BookingException { // for getting all trip completed by a customer
		return null;
		
		
		
		
	}

	@Override
	public String getBillofAtrip(Integer customerId) throws BookingException {  // for fetching total bill spend by a customer
		// TODO Auto-generated method stub
		return null;
	}

}
