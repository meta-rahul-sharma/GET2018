package nqueen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestNQueen {

	@Test
	void testNQueen1() {
		NQueen nQueen = new NQueen();
		Boolean result = nQueen.nQueen(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
				0, 4);
		assertEquals(true, result);
	}

	@Test
	void testNQueen2() {
		NQueen nQueen = new NQueen();
		Boolean result = nQueen.nQueen(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				0, 3);
		assertEquals(false, result);
	}
	
	@Test
	void testNQueen3() {
		NQueen nQueen = new NQueen();
		Boolean result = nQueen.nQueen(new int[][] { { 0, 0 }, { 0, 0 } },
				0, 2);
		assertEquals(false, result);
	}
	
	@Test
	void testNQueen4() {
		NQueen nQueen = new NQueen();
		Boolean result = nQueen.nQueen(new int[][] { { 0} },
				0, 1);
		assertEquals(true, result);
	}

}
