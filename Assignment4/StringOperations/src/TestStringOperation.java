import static org.junit.Assert.*;

import org.junit.Test;


public class TestStringOperation {

	@Test
	public void testIsEqual1() {
		StringMethods string = new StringMethods("shakalaka 99, b()m lakalakaa");
		boolean equal = string.isEquals("rahul sharma");
		assertEquals(false, equal);
		
		String largestWord = string.largestWord();
		assertEquals("lakalakaa", largestWord);
	}
	
	@Test
	public void testIsEqual2() {
		StringMethods string = new StringMethods("shakalaka 99, b()m lakalakaa");
		boolean equal1 = string.isEquals("shakalaka 99, b()m lakalakaa");
		assertEquals(true, equal1);
	}
	
	@Test
	public void testReverse1() {
		StringMethods string = new StringMethods("shakalaka 99, b()m lakalakaa");
		String reverse = string.reverseString();
		assertEquals("aakalakal m)(b ,99 akalakahs", reverse);
	}
	
	@Test
	public void testViceVersa() {
		StringMethods string = new StringMethods("shakalaka 99, b()m lakalakaa");
		String viceVersa = string.viceVersa();
		assertEquals("SHAKALAKA 99, B()M LAKALAKAA", viceVersa);
	}
	
	@Test
	public void testLargestWord() {
		StringMethods string = new StringMethods("shakalaka 99, b()m lakalakaa");
		String largestWord = string.largestWord();
		assertEquals("lakalakaa", largestWord);	
	}

}
