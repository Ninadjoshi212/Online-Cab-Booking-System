package com.flywheelcabs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.BookingException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Invoice;
import com.flywheelcabs.modules.TripDetailDTO;
import com.flywheelcabs.modules.TripDetails;
import com.flywheelcabs.services.TripServices;



// This is the handler or controller for generating REST API 
// All TicketBooking or cab booking related API are handle


@RestController
@RequestMapping("/tripbooking")
public class TripdataControll {
	
	@Autowired
	private TripServices ticketService;

	
//	this method uses post annotation for booking a cab and takes JSON data as Body
	@PostMapping("/ticket")
	public ResponseEntity<TripDetails> bookAtripHandler(@Valid @RequestBody TripDetailDTO ticketDetails) throws BookingException, LoginException, CustomerException, DriverException {
	
	TripDetails details =  ticketService.insertTicketDetails(ticketDetails);
		
	return new ResponseEntity<TripDetails>(details, HttpStatus.CREATED);
	
	}
	
	
//	this method uses PutMapping annotation for updating any booked trip details
	@PutMapping("/ticket")
	public ResponseEntity<TripDetails> updateBookedTripHandler(@RequestBody TripDetailDTO ticketDetails, @RequestParam("id") Integer bookedId) throws BookingException, LoginException {
		
		TripDetails details =  ticketService.updateTicketDetails(ticketDetails, bookedId);
		
		return new ResponseEntity<TripDetails>(details, HttpStatus.CREATED);
		
	}
	
	
//	this method uses DeleteMapping annotation for canceling any ride 
	@DeleteMapping("/ticket")
	public ResponseEntity<TripDetails> cancelABookedTripHandler( @RequestParam("id") Integer tripBookedId) throws BookingException, LoginException {
		
		TripDetails details =  ticketService.deleteTicketDetails(tripBookedId);
		
		return new ResponseEntity<TripDetails>(details, HttpStatus.OK);
		
	}
	
//	for getting all tripHistory
	@GetMapping("/history")
	public ResponseEntity<List<TripDetails>> tripHistoryHandler(@RequestParam("id") Integer customerId) throws BookingException, CustomerException, LoginException { 
		
		List<TripDetails> tripHistory = ticketService.getAllTripDetailsOfACustomer(customerId);
		
		return new ResponseEntity<>(tripHistory, HttpStatus.OK);
		
	}
	
//	for getting invoice for total travels
	@GetMapping("/invoice")
	public ResponseEntity<Invoice> getInvoiceDetails(@RequestParam("id") Integer customerId) throws BookingException, CustomerException, LoginException {
		
		Invoice invoice = ticketService.getInvoiceDetails(customerId);
		
		return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
