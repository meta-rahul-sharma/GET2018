import static org.junit.Assert.*;

import org.junit.Test;

public class TestClumps {

	@Test
	public void testClumps1() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.numbersOfClumps(new int[] { 1, 2, 2, 3, 4, 4 });
		assertEquals(2, result);
	}

	@Test
	public void testClumps2() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.numbersOfClumps(new int[] { 1, 1, 2, 1, 1 });
		assertEquals(2, result);
	}

	@Test
	public void testClumps3() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.numbersOfClumps(new int[] { 1, 1, 1, 1, 1 });
		assertEquals(1, result);
	}

	@Test
	public void testClumps4() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.numbersOfClumps(new int[] { 3, 3, 5, 7, 8, 9, 0, 0, 1, 1,
				1 });
		assertEquals(3, result);
	}

	@Test(expected = AssertionError.class)
	public void testClumps5() {
		ArrayOperations test = new ArrayOperations();
		int result;
		result = test.numbersOfClumps(new int[] {});
		assertEquals(3, result);
	}

}
