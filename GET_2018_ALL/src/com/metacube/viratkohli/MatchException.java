package com.metacube.viratkohli;

/**
 * Exception typing of Match Class
 * @author Rahul Sharma
 * Creation Date: 7/8/2018
 */
@SuppressWarnings("serial")
public class MatchException extends Exception {
	String exception;
	
	public MatchException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	} 
}
