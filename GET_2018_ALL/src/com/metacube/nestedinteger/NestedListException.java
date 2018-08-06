package com.metacube.nestedinteger;

/**
 * Used for Exception handling of nested list class
 * @author Rahul Sharma
 * Creation Date: 6/8/2018
 */
@SuppressWarnings("serial")
public class NestedListException extends Exception {
	String exception;
	
	public NestedListException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	}
}
