package test;

public class Test {
	int[][] array;
	boolean[][] flag;
	int n;
	public Test(int n) {
		int value = 1;
		this.n = n;
		array = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				array[i][j] = value++;
			}
		}
		flag = new boolean[n][n];
	}
	
	
	boolean setRowValues(int actualRow, int row, int[][] setArray, int value) {
		if(value == (n * (n * n + 1)) / 2) {
			return true;
		}
		
		

		for(int i = 0; i < n && row < n -1; i++) {
			if(!flag[row + 1][i] && setRowValues(actualRow, row + 1, setArray, value + array[row + 1][i])) {
				setArray[actualRow][row + 1] = array[row + 1][i];
				flag[row + 1][i] = true;
				return true;
			} 
		}
		 
		return false;
	}
	
	public void algo() {
		int[][] answerArray = new int[n][n];
		for(int i = 0; i < n; i++) {
			answerArray[i][0] = i + 1;
			setRowValues(i, 0, answerArray, i + 1);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(answerArray[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		Test test = new Test(14);
		test.algo();
	}
}
