package com.metacube.infixtopostfix;

@SuppressWarnings("serial")
public class InfixToPostfixException extends Exception {
String exception;
	
	public InfixToPostfixException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	}
}
