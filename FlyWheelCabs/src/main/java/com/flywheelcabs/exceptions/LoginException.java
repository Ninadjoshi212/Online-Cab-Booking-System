package com.flywheelcabs.exceptions;
/*
 *This Exception is unchecked exception extending Exception and this will be used for or this will throw
 * an exception for any problem due to Login operations .
 */
public class LoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException() {
            //No argument Constructor
	}
	public LoginException(String message) {
        super(message);
	}
	
}
