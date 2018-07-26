package com.metacube.programmingfundamental;

/**
 * Creating an user defined object of sparse matrix
 * where object have data members:
 * 1. row
 * 2. column
 * 3. value
 * to store nonZero element at specific location
 * @author Rahul Sharma
 * Creation Date: 26/7/2018
 */
public class SparseMatrix {
	private final int row;
	private final int column;
	private final int value;

	public SparseMatrix(int row, int column, int value) {
		this.row = row;
		this.column = column;
		this.value = value;
	}
	
	public int row() {
		return row;
	}
	
	public int column() {
		return column;
	}
	
	public int value() {
		return value;
	}
}
