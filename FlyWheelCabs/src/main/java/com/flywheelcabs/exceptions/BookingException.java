package com.flywheelcabs.exceptions;
/*
 * This Exception is unchecked exception extending Exception and this will be used for or this will throw
 * an exception for any problem due to  Booking operations .
 */
public class BookingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingException() {
            //No argument Constructor
	}
	public BookingException(String message) {
        super(message);
	}
	
}
