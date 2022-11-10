package com.flywheelcabs.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.BookingException;
import com.flywheelcabs.modules.TripDetailDTO;
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
	public TripDetails insertTicketDetails(TripDetailDTO ticketDetail) throws BookingException { //This method handle the Insertion of a booked ticket details
		
		if(ticketDetail == null) throw new BookingException("Please select aTicket");
		
		TripDetails data = new TripDetails();
		
		Double distance =  Math.floor(Math.random()*(100 - 3 + 1)+ 3); //Random Distance finder
		
		data.setStartingLocation(ticketDetail.getStartingLocation());
		
		data.setDestination(ticketDetail.getDestination());
		
		data.setDate(LocalDate.now());
		
		data.setTime(LocalTime.now());
		
		data.setDistanceInKM(distance);
		
		return ticketDao.save(data);
	}

	@Override
	public TripDetails updateTicketDetails(TripDetailDTO ticketDetails, Integer tripBookedId) throws BookingException { // This method used to update any booked ticket
		
		Optional<TripDetails> optional = ticketDao.findById(tripBookedId);
		
		TripDetails tripdata = optional.get();
		
		if(optional.isPresent()) {
			Double distance =  Math.floor(Math.random()*(100 - 3 + 1)+ 3); //Random Distance finder
			
			tripdata.setStartingLocation(ticketDetails.getStartingLocation());
			
			tripdata.setDestination(ticketDetails.getDestination());
			
			tripdata.setDistanceInKM(distance);
			
			tripdata.setTime(LocalTime.now());
			
			return ticketDao.save(tripdata);
			
		}
		throw new BookingException("No cab booked with bookingId "+tripBookedId); 
		
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
	public String getBilloftrip(Integer customerId) throws BookingException {  // for fetching total bill spend by a customer
		// TODO Auto-generated method stub
		return null;
	}

}
