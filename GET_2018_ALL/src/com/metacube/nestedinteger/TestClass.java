package com.metacube.nestedinteger;

/**
 * Used for Testing purpose of NestedList implementation
 * @author Rahul Sharma
 * Creation Date: 6/8/2018
 */
public class TestClass {
	public static void main(String args[]) throws NestedListException {
		ImplementNestedList implement = new ImplementNestedList();
		implement.addToList(1);
		implement.addToList(20);
		
		ImplementNestedList implement1 = new ImplementNestedList();
		implement1.addToList(1);
		implement1.addToList(implement.getList());
		
		ImplementNestedList implement2 = new ImplementNestedList();
		implement2.addToList(1);
		implement2.addToList(implement1.getList());
		
		ImplementNestedList implement3 = new ImplementNestedList();
		implement3.addToList(1);
		implement3.addToList(2);
		implement3.addToList(implement2.getList());
		implement3.addToList(3);
		implement3.addToList(4);
		implement3.addToList(5);
		int sum = implement3.sum(implement3.getList());
		System.out.println(sum);
		boolean search = implement3.search(implement3.getList(), 18);
		System.out.println(search);
		int largestValue = implement3.largestValue(implement3.getList());
		System.out.println(largestValue);
	}
}
