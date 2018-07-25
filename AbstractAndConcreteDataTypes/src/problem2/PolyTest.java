package problem2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest {

	@Test
	public void testAdd() {
		Poly poly1 = new Poly(new int[][] { { 3, 1 }, { 4, 5 }, { 5, 6 },
				{ 6, 7 }, { -3, 4 } });
		Poly poly2 = new Poly(new int[][] { { 2, 1 }, { 3, 4 }, { 4, 5 },
				{ 5, 6 }, { 6, 7 } });
		int[][] polyAdd = poly1.addPoly(poly2);
		assertArrayEquals(new int[][] { { 5, 1 }, { 0, 4 }, { 8, 5 },
				{ 10, 6 }, { 12, 7 } }, polyAdd);
	}
	

	@Test
	public void testEvaluate() {
		Poly poly = new Poly(new int[][] { { 3, 1 }, { 4, 5 }, { 5, 6 },
				{ 6, 7 }, { -3, 4 } });
		double result = poly.evaluate(5f);
		assertEquals(557515.0, result, .001);
	}

	@Test
	public void testEvaluate1() {
		Poly poly = new Poly(new int[][] { { 3, 1 } });
		double result = poly.evaluate(5f);
		assertEquals(15.0, result, .001);
	}

	@Test
	public void testDegree() {
		Poly poly = new Poly(new int[][] { { 3, 1 }, { 4, 5 }, { 5, 6 },
				{ 6, 7 }, { -3, 4 } });
		int result = poly.degree();
		assertEquals(7, result);
	}

	 @Test
	 public void testMultiply() {
	 Poly poly1 = new Poly(new int[][] { { 3, 1 }, { 4, 5 } });
	 Poly poly2 = new Poly(new int[][] { { -2, 1 }, { 3, 4 } });
	 int[][] result = poly1.multiplyPoly(poly2);
	 assertArrayEquals(new int[][] { { -6, 2 }, { 9, 5 }, { -8, 6 },
				{ 12, 9 } }, result);
	 
	 }

	@Test
	public void testMultiply1() {
		Poly poly1 = new Poly(new int[][] { { 3, 1 }, { 4, 5 }, { 8, 10 } });
		Poly poly2 = new Poly(new int[][] { { 1, 0 }, { 4, 4 }, { 8, 5 } });
		int[][] result = poly1.multiplyPoly(poly2);
		assertArrayEquals(new int[][] { { 3, 1 }, { 16, 5 }, { 24, 6 },
				{ 16, 9 }, { 40, 10 }, { 32, 14 }, { 64, 15 } }, result);
	}
	
	@Test
	public void testDontInsertZeroCoefficient() {
		Poly poly1 = new Poly(new int[][] { { 0, 8 }, { 4, 5 }, { 5, 6 },
				{ 6, 7 }, { -3, 4 } });
		int result = poly1.degree();
		assertEquals(7, result);
	}

}
