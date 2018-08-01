package knightstour;

/**
 * To provide implementation of knight tour problem
 * 
 * @author Rahul Sharma
 */
public class KnightsTourProblem {
	/**
	 * Algorithm of knightsTourProblem(A knight's tour is a sequence of moves of a
	 * knight on a chess board such that the knight visits every square only once)
	 * 
	 * @param knightsTourMatrix
	 *            (matrix to save steps of knight)
	 * @param dimensionOfMatrix
	 *            (matrix array dimension example 8x8)
	 * @param startRow
	 *            give row position to start knight
	 * @param startColumn
	 *            give column position to start knight
	 * @param coveredSquares
	 *            (no of square covered till now)
	 * @return true if knight tour problem solution is possible
	 */
	public Boolean knightsTourMap(int[][] knightsTourMatrix, int dimensionOfMatrix, int startRow, int startColumn,
			int coveredSquares) {
		Boolean knightSolution = false;
		if (coveredSquares == dimensionOfMatrix * dimensionOfMatrix) {
			knightsTourMatrix[startRow][startColumn] = coveredSquares;
			knightSolution = true;
		}

		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		/**
		 * moving knight in all 8 possible places example 
		 * 1. down 2 and right 1/2 
		 * 2. right 2 and down 1/2 
		 * 3. right 2 and up 1/2 
		 * 4. up 2 and right 1/2 
		 * 5. up 2 and left 1/2 
		 * 6. left 2 and up 1/2 
		 * 7. left 2 and down 1/2 
		 * 8. down 2 and left 1/2
		 */
		for (int i = 0; i < dimensionOfMatrix; i++) {
			if (move(knightsTourMatrix, startRow + xMove[i], startColumn + yMove[i], dimensionOfMatrix)) {
				knightsTourMatrix[startRow][startColumn] = coveredSquares;
				if (knightsTourMap(knightsTourMatrix, dimensionOfMatrix, startRow + xMove[i], startColumn + yMove[i],
						coveredSquares + 1)) {
					knightSolution = true;
					break;
				} else {
					knightsTourMatrix[startRow][startColumn] = 0;
				}
			}
		}
		return knightSolution;
	}

	/**
	 * Checks if night was there or not before at a particular position
	 * 
	 * @param knightsTourMatrix
	 * @param row
	 * @param column
	 * @param dimensionOfMatrix
	 * @return true if knight was never at that place before else false
	 */
	public Boolean move(int[][] knightsTourMatrix, int row, int column, int dimensionOfMatrix) {
		Boolean isPlaceAvailable = false;
		if (row >= 0 && row < dimensionOfMatrix && column >= 0 && column < dimensionOfMatrix
				&& knightsTourMatrix[row][column] == 0) {
			isPlaceAvailable = true;
		}
		return isPlaceAvailable;
	}
}
