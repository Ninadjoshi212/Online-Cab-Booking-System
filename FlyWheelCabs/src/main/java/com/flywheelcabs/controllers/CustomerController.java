package com.flywheelcabs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flywheelcabs.exceptions.AdminException;
import com.flywheelcabs.exceptions.BookingException;
import com.flywheelcabs.exceptions.CustomerException;
import com.flywheelcabs.exceptions.DriverException;
import com.flywheelcabs.exceptions.LoginException;
import com.flywheelcabs.modules.Customer;
import com.flywheelcabs.modules.Invoice;
import com.flywheelcabs.modules.LoginDTO;
import com.flywheelcabs.modules.LoginSession;
import com.flywheelcabs.modules.TripDetailDTO;
import com.flywheelcabs.modules.TripDetails;
import com.flywheelcabs.services.CustomerService;
import com.flywheelcabs.services.LoginService;
import com.flywheelcabs.services.TripServices;

/*
	Controller / endPoints (API calls) 
	Will receive the implementation or response from the Service Layer
	Will provide data / response for presentation
*/

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;

	@Autowired
	private LoginService lService;

	@Autowired
	private TripServices tService;

//### Add New customer ###
	@PostMapping("/customer/register")
	public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer)
			throws CustomerException {

		Customer newCustomer = cService.insertCustomer(customer);

		return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}

//### Update Existing customer ###
	@PutMapping("/customer/update")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer)
			throws CustomerException, LoginException {

		Customer updatedCustomer = cService.updateCustomer(customer);

		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.CREATED);
	}

//### Update Password of customer ###
	@PutMapping("/customer/update/")
	public ResponseEntity<Customer> updateCustomerPassword(@RequestParam("mobile") String mobile,
			@RequestParam("oldpass") String oldpass, @RequestParam("newpass") String newpass)
			throws CustomerException, LoginException {

		Customer updatedCustomer = cService.updatePassword(mobile, oldpass, newpass);

		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.CREATED);

	}

//### Delete Account ###
	@DeleteMapping("/customer/delete")
	public ResponseEntity<Customer> deleteAccountHandler(@RequestParam("customerId") Integer customerId)
			throws CustomerException, LoginException {

		Customer deletedCustomer = cService.deleteCustomer(customerId);

		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);

	}

//### Get All customer in a List ###
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomerHandler() throws CustomerException, AdminException {

		List<Customer> customers = cService.getAllCustomers();

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);

	}

//### Get single customer using CustomerId
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable("customerId") Integer customerId)
			throws CustomerException, AdminException {

		Customer fetchedCustomer = cService.getCustomerById(customerId);

		return new ResponseEntity<Customer>(fetchedCustomer, HttpStatus.OK);
	}

//### Get single customer using Mobile ###
	@GetMapping("/customer/mobile")
	public ResponseEntity<Customer> getCustomerByMobileHandler(@RequestParam("mobileNum") String mobile)
			throws CustomerException, AdminException {

		Customer fetchedCustomer = cService.getCustomerByMobile(mobile);

		return new ResponseEntity<Customer>(fetchedCustomer, HttpStatus.OK);
	}

//### Validate customer ###
	@GetMapping("/validate")
	public ResponseEntity<Customer> validateCustomerHandler(@RequestParam("userName") String userName,
			@RequestParam("password") String password) throws CustomerException, AdminException {

		Customer validatedCustomer = cService.validateCustomer(userName, password);

		return new ResponseEntity<Customer>(validatedCustomer, HttpStatus.OK);
	}

//### Rating Driver ###
	@GetMapping("/customer/rate")
	public ResponseEntity<String> rateDriveHandler(@RequestParam("mobile") String mobile,
			@RequestParam("driverUserName") String driverUserName,
			@RequestParam("rating") Float rating) throws DriverException, LoginException {

		String status = cService.rateDriver(mobile, driverUserName,rating);

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

////### Customer Login ###
//	@PostMapping("/customer/login")
//	public ResponseEntity<LoginSession> userLoginHandler(@Valid @RequestBody LoginDTO logindata) throws Exception {
//
//		LoginSession loginSession = lService.userLoginService(logindata);
//
//		return new ResponseEntity<>(loginSession, HttpStatus.CREATED);
//	}
//
////### Customer Logout ###
//	@GetMapping("/customer/logout")
//	public ResponseEntity<String> logoutCustomer(@RequestParam String key) throws CustomerException, LoginException {
//
//		String status = lService.UserLogoutService(key);
//
//		return new ResponseEntity<String>(status, HttpStatus.OK);
//	}
//
////### Book Trip ###
//	@PostMapping("/customer/trip")
//	public ResponseEntity<TripDetails> bookAtripHandler(@Valid @RequestBody TripDetailDTO ticketDetails)
//			throws BookingException, LoginException, CustomerException, DriverException {
//
//		TripDetails details = tService.insertTicketDetails(ticketDetails);
//
//		return new ResponseEntity<TripDetails>(details, HttpStatus.CREATED);
//	}
//
////### Update booked trip ###
//	@PutMapping("/customer/trip")
//	public ResponseEntity<TripDetails> updateBookedTripHandler(@RequestBody TripDetailDTO ticketDetails,
//			@RequestParam("id") Integer bookedId) throws BookingException, LoginException {
//
//		TripDetails details = tService.updateTicketDetails(ticketDetails, bookedId);
//
//		return new ResponseEntity<TripDetails>(details, HttpStatus.CREATED);
//	}
//
////### Cancel Trip ###
//	@DeleteMapping("/customer/trip")
//	public ResponseEntity<TripDetails> cancelBookedTripHandler(@RequestParam("id") Integer tripBookedId)
//			throws BookingException, LoginException {
//
//		TripDetails details = tService.deleteTicketDetails(tripBookedId);
//
//		return new ResponseEntity<TripDetails>(details, HttpStatus.OK);
//	}
//
////### Booking History ###
//	@GetMapping("/customer/trip")
//	public ResponseEntity<List<TripDetails>> tripHistoryHandler(@RequestParam("id") Integer customerId)
//			throws BookingException, CustomerException, LoginException {
//
//		List<TripDetails> tripHistory = tService.getAllTripDetailsOfACustomer(customerId);
//
//		return new ResponseEntity<>(tripHistory, HttpStatus.OK);
//
//	}
//
////### Get invoice ###
//	@GetMapping("/customer/invoice")
//	public ResponseEntity<Invoice> getInvoice(@RequestParam("id") Integer customerId)
//			throws BookingException, CustomerException, LoginException {
//
//		Invoice invoice = tService.getInvoiceDetails(customerId);
//
//		return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
//
//	}

}
