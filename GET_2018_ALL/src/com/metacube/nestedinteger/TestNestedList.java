package com.metacube.nestedinteger;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Used for testing of NestedList functions
 * @author Rahul Sharma
 * Creation Date: 6/8/2018
 */
public class TestNestedList {

	ImplementNestedList implement = new ImplementNestedList();
	List<Object> nestedList = new ArrayList<Object>(asList(1, 2, asList(1, asList(1, asList(90, 99, 1000), 20), 3,
			4, 5, asList(80, 2, asList(5, 4, 3, asList(22, 33, 83))))));
	
	@Test
	public void testSum() throws NestedListException {
		int sum = implement.sum(nestedList);
		assertEquals(1458, sum);
	}
	
	@Test
	public void testLargestValue() throws NestedListException {
		int largestValue = implement.largestValue(nestedList);
		assertEquals(1000, largestValue);
	}
	
	@Test
	public void testSearch() throws NestedListException {
		boolean search = implement.search(nestedList, 20);
		assertEquals(true, search);
	}
	
	@Test
	public void testSearch1() throws NestedListException {
		boolean search = implement.search(nestedList, 89);
		assertEquals(false, search);
	}
	
	@Test
	public void testWrongObjectType() {
		List<Object> nestedList = new ArrayList<Object>(asList(1, 2, asList(1, asList(1, 20), 3, (char)'c', 4, 5)));
		try {
			@SuppressWarnings("unused")
			boolean search = implement.search(nestedList, 5);
			assertEquals(false, true);
		} catch (NestedListException e) {
			assertEquals("Wrong object Type", e.getMessage());
		}	
	}
	
	@Test
	public void testGetValue() throws NestedListException {
		int value = implement.getValue(nestedList, "TTHTHTHH");
		assertEquals(90, value);
	}
	
	@Test
	public void testGetValue1() throws NestedListException {
		int value = implement.getValue(nestedList, "TTHTTTTTHH");
		assertEquals(80, value);
	}
}
