package com.metacube.nestedinteger;

import java.util.List;

/**
 * Implementation of NestedList and its function definition
 * 
 * @author Rahul Sharma Creation Date: 6/8/2018
 */
public class ImplementNestedList implements NestedList {

	/**
	 * To get the total sum of the nested list and return the sum
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int sum(Object object) throws NestedListException {
		int sum = 0;
		// base condition of the recursion
		if (object instanceof Integer) {
			sum = (Integer) object;
		} else if (object instanceof List) {
			// Iterate if object is list
			for (Object iterator : (List) object) {
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
		// base condition of the recursion
		if (object instanceof Integer) {
			largestValue = (Integer) object;
		} else if (object instanceof List) {
			// Iterate if object is list
			for (Object iterator : (List) object) {
				if (!flag) {
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
	 * Return true if given value by user exist in the nested list else returns
	 * false
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean search(Object object, int value) throws NestedListException {
		boolean search = false;
		// base condition of the recursion
		if (object instanceof Integer) {
			if ((Integer) object == value)
				search = true;
		} else if (object instanceof List) {
			// Iterate if object is list
			for (Object iterator : (List) object) {
				if (!search && search(iterator, value)) {
					search = true;
				}
			}
		} else {
			throw new NestedListException("Wrong object Type");
		}
		return search;
	}

	/**
	 * To extract an integer value from a specified position in the nested list.
	 * The position will be specified by a string formed using two characters
	 * ‘H’ (Head) and ‘T’ (Tail). Head represents the first value in the nested
	 * list, whereas the Tail formed by removing the head of the nested list
	 * @param object
	 * @param string
	 * @return traced value
	 * @throws NestedListException
	 */
	@SuppressWarnings("unchecked")
	public int getValue(Object object, String string)
			throws NestedListException {
		int value = 0;
		
		//base condition of getValue Method
		if (string.length() == 0) {
			if (object instanceof Integer) {
				value = (Integer) object;
			} else {
				throw new NestedListException("Get Value String is Wrong");
			}
		} else if (object instanceof List) {
			int stringPosition = 0;
			int objectPosition = 0;
			int stringLength = string.length();
			int objectLength = ((List<Object>) object).size();
			//check until we get Head in string
			while (stringPosition < stringLength
					&& objectPosition < objectLength
					&& string.charAt(stringPosition) == 'T') {
				stringPosition++;
				objectPosition++;
			}

			//if string traced contain head then move for either list or integer recursively
			if (stringPosition < stringLength && objectPosition < objectLength
					&& string.charAt(stringPosition) == 'H') {
				value = getValue(((List<Object>) object).get(objectPosition),
						string.substring(stringPosition + 1, stringLength));
			}
		} else {
			throw new NestedListException("Get Value String is Wrong");
		}
		return value;
	}
}
