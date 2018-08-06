package com.metacube.nestedinteger;

/**
 * 
 * @author Rahul Sharma
 * Creation Date: 6/8/2018
 */
public interface NestedList {
	public int sum(Object list) throws NestedListException;
	public int largestValue(Object list) throws NestedListException;
	public boolean search(Object list, int value) throws NestedListException;
	public void addToList(Object object) throws NestedListException;
}
