package com.flywheelcabs.exceptions;
/*
 * This Exception is unchecked exception extending Exception and this will be used for or this will throw
 * an exception for any problem due to Customer operations .
 */
public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerException() {
            //No argument Constructor
	}
	public CustomerException(String message) {
        super(message);
	}
	
}
