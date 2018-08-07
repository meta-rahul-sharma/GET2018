package com.metacube.priorityqueue;

/**
 * Exception typing of PriorityQueue Class
 * @author Rahul Sharma
 * Creation Date: 7/8/2018
 */
@SuppressWarnings("serial")
public class PriorityQueueException extends Exception {
	String exception;
	
	public PriorityQueueException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	} 
}

