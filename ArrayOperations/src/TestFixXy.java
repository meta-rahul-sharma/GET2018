import static org.junit.Assert.*;

import org.junit.Test;


public class TestFixXy {
	
	@Test
	public void testFixXy1() {
		ArrayOperations test = new ArrayOperations();
		int[] result;
		result = test.fixXy(4, 5, new int[]{5, 4, 9, 4, 9, 5});
		assertArrayEquals(new int[]{9, 4, 5, 4, 5, 9}, result);
	}
	
	@Test
	public void testFixXy2() {
		ArrayOperations test = new ArrayOperations();
		int[] result;
		result = test.fixXy(4, 5, new int[]{1, 4, 1, 5});
		assertArrayEquals(new int[]{1, 4, 5, 1}, result);
	}
	
	@Test
	public void testFixXy3() {
		ArrayOperations test = new ArrayOperations();
		int[] result;
		result = test.fixXy(4, 5, new int[]{1, 4, 1, 5, 5, 4, 1});
		assertArrayEquals(new int[]{1, 4, 5, 1, 1, 4, 5}, result);
	}

}
