package com.metacube.undirectedweightedgraph;

/**
 * Custom Exception Class for Graph Interface
 * @author Rahul Sharma
 * Creation Date: 13/08/2018
 */
@SuppressWarnings("serial")
public class GraphException extends Exception {
	String exception;
	
	public GraphException(String exception) {
		this.exception = exception;
	} 
	
	public String getMessage() {
		return exception;
	}
}
