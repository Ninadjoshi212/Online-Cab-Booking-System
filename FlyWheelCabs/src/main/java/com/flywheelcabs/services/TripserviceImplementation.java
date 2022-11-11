package com.flywheelcabs.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flywheelcabs.exceptions.BookingException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.modules.TripDetailDTO;
import com.flywheelcabs.modules.TripDetails;
import com.flywheelcabs.repositories.CustomerRepo;
import com.flywheelcabs.repositories.LoginSessionDao;
import com.flywheelcabs.repositories.TripdataRepository;

/*
 This is the Service layer. All API call for ticket booking or a tripBooking are handle and
 It contains business or service logics for booking a ticket or respected operations.
 */


@Service
public class TripserviceImplementation  implements TripServices{

	@Autowired
	private TripdataRepository ticketDao; // Dao Interface of ticketBooking for calling respective repository methods.
	

	@Autowired
	private LoginSessionDao loginDao;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public TripDetails insertTicketDetails(TripDetailDTO ticketDetail) throws BookingException, LoginException, CustomerException { //This method handle the Insertion of a booked ticket details
		
		if(ticketDetail == null) throw new BookingException("Please give valid  data to book a cab");
		
		LoginSession existingSession = loginDao.findByMobile(ticketDetail.getMobileNumber()); // checking is user  logged in or not 
		if(existingSession == null) throw new LoginException("Please Login first to book a cab");
		
		Optional<Customer> optional = customerRepo.findById(ticketDetail.getCustomerId()); // finding customer with given id
		
		if(optional == null) throw new CustomerException("customer does not have any account");
		
		Customer existCustomer = optional.get();
		
		TripDetails data = new TripDetails();
		
		data.setCustomer(existCustomer); // adding customer  to trip detail
		
		List<TripDetails> tripList = existCustomer.getTriplist();
		
		Double distance =  Math.floor(Math.random()*(100 - 3 + 1)+ 3); //Random Distance finder
		
		data.setStartingLocation(ticketDetail.getStartingLocation());
		
		data.setDestination(ticketDetail.getDestination());
		
		data.setDate(LocalDate.now());
		
		data.setTime(LocalTime.now());
		
		data.setBill(null);

		data.setCabId(null);
		
		data.setDistanceInKM(distance);
		
		tripList.add(data); // adding trip data to customers trip list.
		
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
