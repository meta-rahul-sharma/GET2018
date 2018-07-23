package knightstour;

public class TestKnight {
	public static void main(String args[]) {
		int[][] array = new int[8][8];
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				array[i][j] = 0;
			}
		}
		KnightsTourProblem knight = new KnightsTourProblem();
		knight.knightsTourMap(array, 8, 0, 0, 1);
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
