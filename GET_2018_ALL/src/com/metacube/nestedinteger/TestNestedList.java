package com.metacube.nestedinteger;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Used for testing of NestedList functions
 * @author Rahul Sharma
 * Creation Date: 6/8/2018
 */
public class TestNestedList {

	ImplementNestedList implement = new ImplementNestedList();
	@Before
	public void test() throws NestedListException {
		implement.addToList(asList(1, 2, asList(1, asList(1, 20), 3, 4, 5)));
	}
	
	@Test
	public void testSum() throws NestedListException {
		int sum = implement.sum(implement.getList());
		assertEquals(37, sum);
	}
	
	@Test
	public void testLargestValue() throws NestedListException {
		int largestValue = implement.largestValue(implement.getList());
		assertEquals(20, largestValue);
	}
	
	@Test
	public void testSearch() throws NestedListException {
		boolean search = implement.search(implement.getList(), 20);
		assertEquals(true, search);
	}
	
	@Test
	public void testSearch1() throws NestedListException {
		boolean search = implement.search(implement.getList(), 'c');
		assertEquals(false, search);
	}
	
	@Test
	public void testWrongObjectType() {
		ImplementNestedList implement = new ImplementNestedList();
		try {
			implement.addToList(asList(1, 2, asList(1, asList(1, 20), 3, 4, "c", 5)));
			boolean search = implement.search(implement.getList(), 5);
			assertEquals(false, true);
		} catch (NestedListException e) {
			assertEquals("Wrong object Type", e.getMessage());
		}	
	}
}
