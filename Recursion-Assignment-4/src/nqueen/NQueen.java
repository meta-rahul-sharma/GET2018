package nqueen;

/**
 * Implementation of N Queen Problem(The N Queen is the problem of placing N chess queens on
 * an N×N chess board so that no two queens attack each other)
 * @author Rahul Sharma
 */
public class NQueen {

	/**
	 * 
	 * @param nQueenArray of NxN matrix with initial values as zero's
	 * @param startRow from where we are starting our algorithm
	 * @param dimensionOfMatrix
	 * @return true iff NxN board can Implement N Queen Problem
	 */
	public Boolean nQueen(int[][] nQueenArray, int startRow, int dimensionOfMatrix) {
		Boolean nQueenResult = false;
		int column;
		if (startRow >= dimensionOfMatrix) {
			nQueenResult = true;

		} else {

			for (column = 0; column < dimensionOfMatrix; column++) {
				if (!checkOtherQueen(nQueenArray, startRow, column, dimensionOfMatrix)) {
					nQueenArray[startRow][column] = 1;
					if (nQueen(nQueenArray, startRow + 1, dimensionOfMatrix)) {
						nQueenResult = true;
						break;
					} else {
						nQueenArray[startRow][column] = 0;
					}
				}
			}

			if (column == dimensionOfMatrix) {
				nQueenResult = false;
			}
		}
		return nQueenResult;
	}

	/**
	 * checks only upper rows matrix nQueenArray [][] because lower one not given
	 * value 1 till and we are moving from upper part to lower part of matrix
	 * nQueenArray [][] example from row 0 to row dimensionOfMatrix - 1
	 * 
	 * @param nQueenArray
	 * @param row
	 * @param column
	 * @param dimensionOfMatrix
	 * @return true is other queen's are attacking
	 */
	public Boolean checkOtherQueen(int[][] nQueenArray, int row, int column, int dimensionOfMatrix) {
		Boolean attack = false;
		/**
		 * checks upper rows element in the same column
		 */
		for (int i = 0; i < row; i++) {
			// System.out.println("i: " + i + " j: " + row +" first");
			if (nQueenArray[i][column] == 1) {
				attack = true;
				break;
			}
		}

		/**
		 * checks upper right diagonal elements
		 */
		for (int i = row, j = column; i >= 0 && j < dimensionOfMatrix; i--, j++) {
			// System.out.println("i: " + i + " j: " + j +" second");
			if (nQueenArray[i][j] == 1) {
				attack = true;
				break;
			}
		}

		/**
		 * checks upper left diagonal elements
		 */
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			// System.out.println("i: " + i + " j: " + j + " third");
			if (nQueenArray[i][j] == 1) {
				attack = true;
				break;
			}
		}
		return attack;
	}
}
