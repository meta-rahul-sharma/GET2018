package com.metacube.json;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import com.metacube.nestedinteger.ImplementNestedList;
import com.metacube.nestedinteger.NestedListException;

/**
 * To test json file input and parse data using json parser
 * @author Rahul Sharma
 * Creation Date: 9/8/2018
 */
public class TestJson {
	ImplementNestedList implement = new ImplementNestedList();
	Json read = new Json();
	List<Object> nestedList ;
	
	@Before
	public void getListFromJsonFile() throws FileNotFoundException, IOException, ParseException, NestedListException {
		nestedList = read.generateNestedListFromFile("data1.json");
	}
	
	@Test
	public void testSum() throws NestedListException {
		int sum = implement.sum(nestedList);
		assertEquals(1358, sum);
	}
	
	@Test
	public void testLargestValue() throws NestedListException {
		int largestValue = implement.largestValue(nestedList);
		assertEquals(900, largestValue);
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
	public void testWrongObjectType() throws FileNotFoundException, IOException, ParseException {
		try {
			@SuppressWarnings("unused")
			List<Object> nestedList = read.generateNestedListFromFile("data2.json");
			assertEquals(false, true);
		} catch (NestedListException e) {
			assertEquals("Wrong object Type", e.getMessage());
		}	
	}
}
