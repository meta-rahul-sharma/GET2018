package com.metacube.stack;

@SuppressWarnings("serial")
public class StackException extends Exception{
	String exception;
	
	public StackException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	}
}
