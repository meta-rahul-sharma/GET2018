package com.metacube.evaluatepostfix;

@SuppressWarnings("serial")
public class EvaluatePostfixException extends Exception {
String exception;
	
	public EvaluatePostfixException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	}
}
