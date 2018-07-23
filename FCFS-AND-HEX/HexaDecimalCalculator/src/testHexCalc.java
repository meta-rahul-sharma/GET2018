import static org.junit.Assert.*;

import org.junit.Test;

public class testHexCalc {

	@Test
	public void testAdd() {
		HexCalc calculate = new HexCalc();
		String add = calculate.add("45", "67");
		assertEquals("ac", add);
	}

	@Test
	public void testSubtract() {
		HexCalc calculate = new HexCalc();
		String subtract = calculate.subtract("45", "67");
		assertEquals("-22", subtract);
	}

	@Test
	public void testMultiply() {
		HexCalc calculate = new HexCalc();
		String multiply = calculate.multiply("45", "67");
		assertEquals("1bc3", multiply);
	}

	@Test(expected = AssertionError.class)
	public void testDivide() {
		HexCalc calculate = new HexCalc();
		String divide = calculate.divide("45", "0");
		assertEquals("0", divide);
	}

	@Test
	public void testDivide1() {
		HexCalc calculate = new HexCalc();
		String divide = calculate.divide("45", "2");
		assertEquals("22", divide);
	}

	@Test
	public void testIsLess() {
		HexCalc calculate = new HexCalc();
		boolean isLess = calculate.isLessThan("45", "67");
		assertEquals(true, isLess);
	}

	@Test
	public void testIsLess1() {
		HexCalc calculate = new HexCalc();
		boolean isLess1 = calculate.isLessThan("45", "45");
		assertEquals(false, isLess1);
	}

	@Test
	public void testIsGreater() {
		HexCalc calculate = new HexCalc();
		boolean isGreater = calculate.isGreaterThan("45", "67");
		assertEquals(false, isGreater);
	}

	@Test
	public void testIsGreater1() {
		HexCalc calculate = new HexCalc();
		boolean isGreater1 = calculate.isGreaterThan("45", "45");
		assertEquals(false, isGreater1);
	}

	@Test
	public void testIsEqual() {
		HexCalc calculate = new HexCalc();
		boolean isEqual = calculate.isEqual("ef", "ef");
		assertEquals(true, isEqual);
	}

	@Test
	public void testIsEqual1() {
		HexCalc calculate = new HexCalc();
		boolean isEqual = calculate.isEqual("ef", "ee");
		assertEquals(false, isEqual);
	}

}
