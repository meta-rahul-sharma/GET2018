package com.metacube.nestedinteger;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

/**
 * Used for Testing purpose of NestedList implementation
 * @author Rahul Sharma
 * Creation Date: 6/8/2018
 */
public class TestClass {
	public static void main(String args[]) throws NestedListException {
		ImplementNestedList implement = new ImplementNestedList();
		List<Object> nestedList = new ArrayList<Object>(asList(1, 2, asList(1, asList(1, asList(90, 99, 1000), 20), 3,
				4, 5, asList(80, 2, asList(5, 4, 3, asList(22, 33, 83))))));
		int sum = implement.sum(nestedList);
		System.out.println(sum);
		boolean search = implement.search(nestedList, 99);
		System.out.println(search);
		int largestValue = implement.largestValue(nestedList);
		System.out.println(largestValue);
	}
}
