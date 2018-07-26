package com.metacube.programmingfundamental;

import java.util.ArrayList;
import java.util.List;
/**
 * Implementation of Immutable Class SparseMatrixOperations where SparseMatrix operations like:
 * 1. transpose
 * 2. Add
 * 3. Multiply 
 * 4. Symmetric 
 * are defined
 * @author Rahul Sharma
 * Creation Date: 26/7/2018
 */
public final class SparseMatrixOperations {
	private final int rows;
	private final int columns;
	private final List<SparseMatrix> sparse;
	
	/**
	 * Constructor of the SparseMatrixOperations class
	 * where we are initializing objects
	 * @param matrix
	 */
	public SparseMatrixOperations(int[][] matrix) {
		if (matrix == null) {
			throw new NullPointerException("Null Reference");
		}

		if (matrix.length == 0) {
			throw new RuntimeException("Matrix Invalid");
		}

		rows = matrix.length;
		columns = matrix[0].length;

		sparse = convertToSparse(matrix);

		int halfMarrixSize = 2;
		if (sparse.size() > matrix.length * matrix[0].length / halfMarrixSize) {
			throw new RuntimeException("Not Sparse Matrix");
		}
	}

	/**
	 * @return transpose matrix of the sparse matrix
	 */
	public int[][] transpose() {
		int[][] matrix = convertToMatrix();
		int[][] transpose = new int[columns][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				transpose[j][i] = matrix[i][j];
			}
		}
		return transpose;
	}

	/**
	 * Used for addition of 2 sparseMatrix
	 * @param another	It is object of SparseMatrixOperations class 
	 * @return Addition of "this" object "another" object of SparseMatrixOperations class 
	 */
	public int[][] add(SparseMatrixOperations another) {
		if(this.rows != another.rows || this.columns != another.columns) {
			throw new RuntimeException("Invalid Addition");
		}
		int[][] thisMatrix = convertToMatrix();
		int[][] anotherMatrix = another.convertToMatrix();
		int[][] add = new int[this.rows][another.columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				add[i][j] = thisMatrix[i][j]+anotherMatrix[i][j];	
			}
		}
		return add;
	}

	public boolean symmetric() {
		boolean symmetric = true;
		if (rows == columns) {
			int[][] matrix = convertToMatrix();
			for (int i = 0; i < rows; i++) {
				for (int j = i; j < columns; j++) {
					if(matrix[i][j] != matrix[j][i]) {
						symmetric = false;
					}
				}
			}
		} else {
			throw new RuntimeException("Invalid for Symmetric");
		}
		return symmetric;
	}

	/**
	 * Used for Multiplication of 2 sparseMatrix
	 * @param another	It is object of SparseMatrixOperations class 
	 * @return Multiplication of "this" object "another" object of SparseMatrixOperations class 
	 */
	public int[][] multiply(SparseMatrixOperations another) {
		if(this.columns != another.rows) {
			throw new RuntimeException("Invalid Multiplication");
		}
		
		int[][] thisMatrix = convertToMatrix();
		int[][] anotherMatrix = another.convertToMatrix();
		int[][] product = new int[this.rows][another.columns];
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j< another.columns; j++) {
				for(int k = 0; k < this.columns; k++) {
					product[i][j] += thisMatrix[i][k]*anotherMatrix[k][j];
				}
			}
		}
		return product;
	}
	
	/**
	 * @return Simple Matrix which is conversion of sparse Matrix
	 */
	private int[][] convertToMatrix() {
		int[][] result = new int[rows][columns];
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (index < sparse.size() && sparse.get(index).row() == i
						&& sparse.get(index).column() == j) {
					result[i][j] = sparse.get(index).value();
					System.out.print(result[i][j]+"\t");
					index++;
				} else {
					result[i][j] = 0;
					System.out.print(result[i][j]+"\t");
				}
			}
			System.out.println();
		}
		return result;
	}

	/**
	 * Used for conversion of simple Matrix to SparseMatrix
	 * @param matrix	It is simple Matrix
	 * @return Converted Simple 2D matrix
	 */
	private List<SparseMatrix> convertToSparse(int[][] matrix) {
		List<SparseMatrix> sparse = new ArrayList<SparseMatrix>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					sparse.add(new SparseMatrix(i, j, matrix[i][j]));
				}
			}
		}
		return sparse;
	}
}
