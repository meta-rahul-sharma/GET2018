package com.metacube.dictionary;

/**
 * Custom Exception for Dictionary Interface
 * @author Rahul Sharma
 * Creation Date: 9/8/2018
 */
@SuppressWarnings("serial")
public class DictionaryException extends Exception {
	String exception;
	
	public DictionaryException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	}
}
