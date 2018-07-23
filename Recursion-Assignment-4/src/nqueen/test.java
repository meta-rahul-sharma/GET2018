package nqueen;

public class test {
	public static void main(String args[]) {
		NQueen nQueen = new NQueen();
		int[][] array = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		Boolean result = nQueen.nQueen(array, 0, 6);
		System.out.println(result);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
