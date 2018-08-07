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
	
	public void addToList(Object object) throws NestedListException {
		if(object instanceof List || object instanceof Integer) {
			nestedList.add(object);
		} else {
			throw new NestedListException("Wrong object Type");
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int sum(Object object) throws NestedListException {
		int sum = 0;
		if(object instanceof Integer) {
			sum = (Integer) object;
		} else if(object instanceof List) {
			for(Object iterator: (List)object) {
				sum += sum(iterator);
			}
		} else {
			throw new NestedListException("Wrong object Type");
		}
		return sum;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int largestValue(Object object) throws NestedListException {
		int largestValue = 0;
		boolean flag = false;
		if(object instanceof Integer) {
			largestValue = (Integer) object;
		} else if(object instanceof List) {
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

	@SuppressWarnings("rawtypes")
	@Override
	public boolean search(Object object, int value) throws NestedListException {
		boolean search = false;
		if(object instanceof Integer) {
			if((Integer) object == value)
			search = true;
		} else if(object instanceof List) {
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
	
	/*public int getValue(Object object, String traverse) throws NestedListException {
		int value = 0;
		if(traverse.charAt(traverse.length()-1) == (char)'T') {
			throw new NestedListException("Not valid traversal string");
		}
		
		if(object instanceof Integer && traverse.length() == 1) {
			value = (Integer) object;
		} else if(object instanceof List) {
			int stringIndex = 0;
			int listIndex = 0;
			while(stringIndex < traverse.length() && listIndex < )
		}
		return value;
	}*/
	
	public List<Object> getList() {
		return nestedList;
	}

}
