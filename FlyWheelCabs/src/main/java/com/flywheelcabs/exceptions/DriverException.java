package com.flywheelcabs.exceptions;
/*
 *This Exception is unchecked exception extending Exception and this will be used for or this will throw
 * an exception for any problem due to Driver operations .
 */
public class DriverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DriverException() {
            //No argument Constructor
	}
	public DriverException(String message) {
        super(message);
	}
	
}
