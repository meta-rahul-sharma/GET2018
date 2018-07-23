package knightstour;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestKnightTour {

	@Test
	void testKnightTour1() {
		KnightsTourProblem knight = new KnightsTourProblem();
		int[][] knightMatrixArray = new int[8][8];
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				knightMatrixArray[i][j] = 0;
			}
		}
		
		//knight start from row 0 column 0
		Boolean result = knight.knightsTourMap(knightMatrixArray, 8, 0, 0, 1);
		assertEquals(true, result);
	}
	
	@Test
	void testKnightTour2() {
		KnightsTourProblem knight = new KnightsTourProblem();
		int[][] knightMatrixArray = new int[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				knightMatrixArray[i][j] = 0;
			}
		}
		
		//knight start from row 0 column 0
		Boolean result = knight.knightsTourMap(knightMatrixArray, 3, 0, 0, 1);
		assertEquals(false, result);
	}
	
	@Test
	void testKnightTour3() {
		KnightsTourProblem knight = new KnightsTourProblem();
		int[][] knightMatrixArray = new int[4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				knightMatrixArray[i][j] = 0;
			}
		}
		
		//knight start from row 0 column 0
		Boolean result = knight.knightsTourMap(knightMatrixArray, 4, 0, 0, 1);
		assertEquals(false, result);
	}
	
	@Test
	void testKnightTour4() {
		KnightsTourProblem knight = new KnightsTourProblem();
		int[][] knightMatrixArray = new int[8][8];
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				knightMatrixArray[i][j] = 0;
			}
		}
		
		//knight start from row 0 column 7
		Boolean result = knight.knightsTourMap(knightMatrixArray, 8, 0, 7, 1);
		assertEquals(true, result);
	}
	
	@Test
	void testKnightTour5() {
		KnightsTourProblem knight = new KnightsTourProblem();
		int[][] knightMatrixArray = new int[8][8];
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				knightMatrixArray[i][j] = 0;
			}
		}
		
		//knight start from row 7 column 0
		Boolean result = knight.knightsTourMap(knightMatrixArray, 8, 7, 0, 1);
		assertEquals(true, result);
	}

}
