package com.metacube.employee;

/**
 * Custom Exception for Employee
 * @author Rahul Sharma
 * Creation Date: 8/8/2018
 */
@SuppressWarnings("serial")
public class EmployeeException extends Exception {
	String exception;
	
	public EmployeeException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	}
}
