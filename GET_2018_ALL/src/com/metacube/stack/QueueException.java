package com.metacube.stack;

public class QueueException extends Exception {
	String message;
	public QueueException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
