package search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSearch {

	@Test
	void testLinear1() {
		Search search = new Search();
		int element = 15;
		int start = 0;
		int index = search.linearSearch(new int[] { 5, 4, 10, 8, 15, 21, 32, 38 }, element, start);
		assertEquals(4, index);
	}
	
	@Test
	void testLinear2() {
		Search search = new Search();
		int element = 34;
		int start = 0;
		int index = search.linearSearch(new int[] { 5, 4, 10, 8, 15, 21, 32, 38 }, element, start);
		assertEquals(-1, index);
	}
	
	@Test
	void testBinary1() {
		Search search = new Search();
		int[] array = new int[] { 4, 5, 8, 10, 15, 21, 32, 38 };
		int element = 15;
		int start = 0;
		int end = array.length;
		int index = search.binarySearch(array, element, start, end);
		assertEquals(4, index);
	}
	
	@Test
	void testBinary2() {
		Search search = new Search();
		int[] array = new int[] { 4, 5, 8, 10, 15, 21, 32, 38 };
		int element = 5;
		int start = 0;
		int end = array.length;
		int index = search.binarySearch(array, element, start, end);
		assertEquals(1, index);
	}
	
	@Test
	void testBinary3() {
		Search search = new Search();
		int[] array = new int[] { 4, 5, 8, 10, 15, 21, 32, 38 };
		int element = 9;
		int start = 0;
		int end = array.length;
		int index = search.binarySearch(array, element, start, end);
		assertEquals(-1, index);
	}

}
