package com.metacube.undirectedweightedgraph;

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
