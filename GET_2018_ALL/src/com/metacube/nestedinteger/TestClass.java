package com.metacube.nestedinteger;

import static java.util.Arrays.asList;

/**
 * Used for Testing purpose of NestedList implementation
 * 
 * @author Rahul Sharma Creation Date: 6/8/2018
 */
public class TestClass {
	public static void main(String args[]) throws NestedListException {
		ImplementNestedList implement = new ImplementNestedList();
		implement.addToList(asList(1, 2, asList(1, asList(1, 20), 3, 4, 5)));
		int sum = implement.sum(implement.getList());
		System.out.println(sum);
		boolean search = implement.search(implement.getList(), 3);
		System.out.println(search);
		int largestValue = implement.largestValue(implement.getList());
		System.out.println(largestValue);
	}
}
