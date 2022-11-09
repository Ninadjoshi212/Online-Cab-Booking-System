package com.flywheelcabs.exceptions;
/*
 * This Exception is unchecked exception extending Exception and this will be used for or this will throw
 * an exception for any problem due to Admin operations .
 */
public class AdminException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminException() {
            //No argument Constructor
	}
	public AdminException(String message) {
        super(message);
	}
	
}
