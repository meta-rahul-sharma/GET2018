import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author Rahul Sharma
 *Creation Date: 19/7/2018
 */

public class TestSplitArray {

	@Test
	public void testSplit1() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.splitArray(new int[]{1, 1, 1, 2, 1});
		assertEquals(3, result);
	}
	
	@Test
	public void testSplit2() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.splitArray(new int[]{2, 1, 1, 2, 1});
		assertEquals(-1, result);
	}
	
	@Test
	public void testSplit3() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.splitArray(new int[]{10, 10});
		assertEquals(1, result);
	}
	
	@Test
	public void testSplit4() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.splitArray(new int[]{});
		assertEquals(-1, result);
	}

}
