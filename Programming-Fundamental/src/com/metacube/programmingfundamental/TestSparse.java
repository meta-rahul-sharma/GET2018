package com.metacube.programmingfundamental;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * Used for testing purpose of sparse matrix operations
 * @author Rahul Sharma
 * Creation Date: 26/7/2018
 */
public class TestSparse {

	/**
	 * Testing if length of the matrix is zero and give matrix invalid message
	 */
	@Test
	public void testMatrixInvalidException() {
		int[][] matrix = new int[][] {};
		try {
			SparseMatrixOperations operations = new SparseMatrixOperations(matrix);
		} catch (RuntimeException ex) {
			assertEquals("Matrix Invalid", ex.getMessage());
		}
	}

	/**
	 * Testing matrix that it is sparse or not
	 */
	@Test
	public void testNotSparseMatrixException() {
		int[][] matrix = new int[][] { { 1, 2 }, { 2, 1 } };
		try {
			SparseMatrixOperations operations = new SparseMatrixOperations(matrix);
		} catch (RuntimeException ex) {
			assertEquals("Not Sparse Matrix", ex.getMessage());
		}
	}

	/**
	 * Testing Null pointer exception if null pointer given to matrix
	 */
	@Test
	public void testNullPointerException() {
		int[][] matrix = null;
		try {
			SparseMatrixOperations operations = new SparseMatrixOperations(matrix);
		} catch (NullPointerException ex) {
			assertEquals("Null Reference", ex.getMessage());
		}
	}

	/**
	 * Testing Symmetric Operation
	 */
	@Test
	public void testSymmetric1() {
		int[][] matrix = new int[][] { { 0, 1, 0 }, { 1, 0, 3 }, { 0, 3, 0 } };

		SparseMatrixOperations operations = new SparseMatrixOperations(matrix);
		boolean result = operations.symmetric();
		assertEquals(true, result);

	}

	/**
	 * Testing addition Operation
	 */
	@Test
	public void testAdd() {
		int[][] matrixFirst = new int[][] { { 0, 1, 0 }, { 1, 0, 3 }, { 0, 3, 0 } };
		int[][] matrixSecond = new int[][] { { 1, 2, 3 }, { 0, 0, 0 }, { 0, 0, 7 } };

		SparseMatrixOperations sparseFirst = new SparseMatrixOperations(matrixFirst);
		SparseMatrixOperations sparseSecond = new SparseMatrixOperations(matrixSecond);
		int[][] result = sparseFirst.add(sparseSecond);
		assertArrayEquals(new int[][] { { 1, 3, 3 }, { 1, 0, 3 }, { 0, 3, 7 } }, result);

	}

	/**
	 * Testing addition Operation
	 */
	@Test
	public void testAdd1() {
		int[][] matrixFirst = new int[][] { { 0, 1, 0 }, { 1, 0, 3 }, { 0, 3, 0 } };
		int[][] matrixSecond = new int[][] { { 1, 2, 3 }, { 0, 0, 0 } };

		SparseMatrixOperations sparseFirst = new SparseMatrixOperations(matrixFirst);
		SparseMatrixOperations sparseSecond = new SparseMatrixOperations(matrixSecond);
		try {
			int[][] result = sparseFirst.add(sparseSecond);
		} catch (RuntimeException ex) {
			assertEquals("Invalid Addition", ex.getMessage());
		}
	}

	/**
	 * Testing Symmetric Operation
	 */
	@Test
	public void testSymmetric2() {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 0, 0, 0 }, { 0, 0, 7 } };

		SparseMatrixOperations operations = new SparseMatrixOperations(matrix);
		boolean result = operations.symmetric();
		assertEquals(false, result);

	}

	/**
	 * Testing Symmetric Operation
	 */
	@Test
	public void testSymmetric3() {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 7, 7 } };
		try {
			SparseMatrixOperations operations = new SparseMatrixOperations(matrix);
			boolean result = operations.symmetric();
			assertEquals(false, result);
		} catch (RuntimeException ex) {
			assertEquals("Not Sparse Matrix", ex.getMessage());
		}
	}

	/**
	 * Testing Transpose
	 */
	@Test
	public void testTranspose() {
		int[][] matrix = new int[][] { { 0, 1, 0 }, { 1, 0, 3 }, { 0, 3, 0 } };
		try {
			SparseMatrixOperations operations = new SparseMatrixOperations(matrix);
			int[][] result = operations.transpose();
			assertArrayEquals(new int[][] { { 0, 1, 0 }, { 1, 0, 3 }, { 0, 3, 0 } }, result);
		} catch (RuntimeException ex) {
			assertEquals("Not Sparse Matrix", ex.getMessage());
		}
	}

	/**
	 * Testing Transpose
	 */
	@Test
	public void testTranspose1() {
		int[][] matrix = new int[][] { { 0, 1, 0 }, { 1, 0, 3 } };
		try {
			SparseMatrixOperations operations = new SparseMatrixOperations(matrix);
			int[][] result = operations.transpose();
			assertArrayEquals(new int[][] { { 0, 1 }, { 1, 0 }, { 0, 3 } }, result);
		} catch (RuntimeException ex) {
			assertEquals("Not Sparse Matrix", ex.getMessage());
		}
	}

	/**
	 * Testing Multiplication
	 */
	@Test
	public void testMultiply1() {
		int[][] matrixFirst = new int[][] { { 1, 0 }, { 0, 1 } };
		int[][] matrixSecond = new int[][] { { 0, 2 }, { 2, 0 } };

		SparseMatrixOperations sparseFirst = new SparseMatrixOperations(matrixFirst);
		SparseMatrixOperations sparseSecond = new SparseMatrixOperations(matrixSecond);
		try {
			int[][] result = sparseFirst.multiply(sparseSecond);
			assertArrayEquals(new int[][] { { 0, 2 }, { 2, 0 } }, result);

		} catch (RuntimeException ex) {
			assertEquals("Invalid Multiplication", ex.getMessage());
		}
	}

	/**
	 * Testing Multiplication
	 */
	@Test
	public void testMultiply2() {
		int[][] matrixFirst = new int[][] { { 1, 0 }, { 0, 1 }, { 3, 0 } };
		int[][] matrixSecond = new int[][] { { 0, 2 }, { 2, 0 } };

		SparseMatrixOperations sparseFirst = new SparseMatrixOperations(matrixFirst);
		SparseMatrixOperations sparseSecond = new SparseMatrixOperations(matrixSecond);
		try {
			int[][] result = sparseFirst.multiply(sparseSecond);
			assertArrayEquals(new int[][] { { 0, 2 }, { 2, 0 }, { 0, 6 } }, result);

		} catch (RuntimeException ex) {
			assertEquals("Invalid Multiplication", ex.getMessage());
		}
	}
	
	/**
	 * Testing Multiplication
	 */
	@Test
	public void testMultiply3() {
		int[][] matrixFirst = new int[][] { { 1, 0 }, { 0, 1 }, { 3, 0 } };
		int[][] matrixSecond = new int[][] { { 0, 2 } };

		SparseMatrixOperations sparseFirst = new SparseMatrixOperations(matrixFirst);
		SparseMatrixOperations sparseSecond = new SparseMatrixOperations(matrixSecond);
		try {
			int[][] result = sparseFirst.multiply(sparseSecond);
			assertArrayEquals(new int[][] { { 0, 2 }, { 2, 0 }, { 0, 6 } }, result);

		} catch (RuntimeException ex) {
			assertEquals("Invalid Multiplication", ex.getMessage());
		}
	}

}
