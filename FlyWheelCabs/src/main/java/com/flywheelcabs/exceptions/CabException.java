package com.flywheelcabs.exceptions;
/*
 * This Exception is unchecked exception extending Exception and this will be used for or this will throw
 * an exception for any problem due to Cab operations .
 */
public class CabException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CabException() {
            //No argument Constructor
	}
	public CabException(String message) {
        super(message);
	}
	
}
