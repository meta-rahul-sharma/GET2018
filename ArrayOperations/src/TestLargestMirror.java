import static org.junit.Assert.*;

import org.junit.Test;


public class TestLargestMirror {

	@Test
	public void testMirror1() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.largestMirrorSeciton(new int[]{1, 2, 3, 8, 9, 3, 2, 1});
		assertEquals(3, result);
	}
	
	@Test
	public void testMirror2() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.largestMirrorSeciton(new int[]{7, 1, 4, 9, 7, 4, 1});
		assertEquals(2, result);
	}
	
	@Test
	public void testMirror3() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.largestMirrorSeciton(new int[]{1, 2, 1, 4});
		assertEquals(3, result);
	}
	
	@Test
	public void testMirror4() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.largestMirrorSeciton(new int[]{1, 4, 5, 3, 5, 4, 1});
		assertEquals(7, result);
	}
	
	@Test
	public void testMirror5() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.largestMirrorSeciton(new int[]{1, 2, 3, 4, 5, 1, 2, 2, 1});
		assertEquals(4, result);
	}
	
	@Test
	public void testMirror6() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.largestMirrorSeciton(new int[]{});
		assertEquals(4, result);
	}

}
