package com.metacube.nestedinteger;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Used for testing of NestedList functions
 * @author Rahul Sharma
 * Creation Date: 6/8/2018
 */
public class TestNestedList {

	ImplementNestedList implement3 = new ImplementNestedList();
	@Before
	public void test() throws NestedListException {
		ImplementNestedList implement = new ImplementNestedList();
		implement.addToList(1);
		implement.addToList(20);
		
		ImplementNestedList implement1 = new ImplementNestedList();
		implement1.addToList(1);
		implement1.addToList(implement.getList());
		
		ImplementNestedList implement2 = new ImplementNestedList();
		implement2.addToList(1);
		implement2.addToList(implement1.getList());
		
		implement3.addToList(1);
		implement3.addToList(2);
		implement3.addToList(implement2.getList());
		implement3.addToList(3);
		implement3.addToList(4);
		implement3.addToList(5);
	}
	
	@Test
	public void testSum() throws NestedListException {
		int sum = implement3.sum(implement3.getList());
		assertEquals(38, sum);
	}
	
	@Test
	public void testLargestValue() throws NestedListException {
		int largestValue = implement3.largestValue(implement3.getList());
		assertEquals(20, largestValue);
	}
	
	@Test
	public void testSearch() throws NestedListException {
		boolean search = implement3.search(implement3.getList(), 20);
		assertEquals(true, search);
	}
}
