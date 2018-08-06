package com.metacube.nestedinteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of NestedList and its function definition
 * @author Rahul Sharma
 * Creation Date: 6/8/2018
 */
public class ImplementNestedList implements NestedList{

	private List<Object> nestedList = new ArrayList<Object>();
	
	/**
	 * To add list or integer as object to the list
	 */
	@Override
	public void addToList(Object object) throws NestedListException {
		if(object instanceof List || object instanceof Integer) {
			nestedList.add(object);
		} else {
			throw new NestedListException("Wrong object Type");
		}
	}

	/**
	 * To get the total sum of the nested list and return the sum
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int sum(Object object) throws NestedListException {
		int sum = 0;
		//base condition of the recursion
		if(object instanceof Integer) {
			sum = (Integer) object;
		} else if(object instanceof List) {
			//Iterate if object is list
			for(Object iterator: (List)object) {
				sum += sum(iterator);
			}
		} else {
			throw new NestedListException("Wrong object Type");
		}
		return sum;
	}

	/**
	 * To return largest value in the nested list
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int largestValue(Object object) throws NestedListException {
		int largestValue = 0;
		boolean flag = false;
		//base condition of the recursion
		if(object instanceof Integer) {
			largestValue = (Integer) object;
		} else if(object instanceof List) {
			//Iterate if object is list
			for(Object iterator: (List)object) {
				if(!flag) {
					largestValue = largestValue(iterator);
					flag = true;
				}
				largestValue = Math.max(largestValue, largestValue(iterator));
			}
		} else {
			throw new NestedListException("Wrong object Type");
		}
		return largestValue;
	}

	/**
	 * Return true if given value by user exist in the nested list
	 * else returns false
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean search(Object object, int value) throws NestedListException {
		boolean search = false;
		//base condition of the recursion
		if(object instanceof Integer) {
			if((Integer) object == value)
			search = true;
		} else if(object instanceof List) {
			//Iterate if object is list
			for(Object iterator: (List)object) {
				if(!search && search(iterator, value)) {
					search = true;
				}
			}
		} else {
			throw new NestedListException("Wrong object Type");
		}
		return search;
	}
	
	public List<Object> getList() {
		return nestedList;
	}
}
