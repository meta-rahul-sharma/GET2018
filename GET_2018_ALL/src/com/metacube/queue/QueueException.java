package com.metacube.queue;

@SuppressWarnings("serial")
public class QueueException extends Exception {
	String exception;
	
	public QueueException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	}
}
