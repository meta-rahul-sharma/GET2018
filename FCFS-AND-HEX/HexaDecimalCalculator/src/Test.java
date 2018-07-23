import java.util.Scanner;
/**creation date 17/7/2018
 * @author rahul sharma
 * 
 */
public class Test {
	private static Scanner in;

	/**
	 * main function to run program
	 * @param args
	 */
	public static void main(String args[]) {
		boolean loop;
		do {
			HexCalc calculate = new HexCalc();
			in = new Scanner(System.in);
			System.out.println("Enter first hex");
			String hexFirst= in.nextLine();
			
			System.out.println("Enter second hex");
			String hexSecond= in.nextLine();
			if(calculate.checkHex(hexFirst) && calculate.checkHex(hexSecond)) {
			    System.out.println("1. addHex"+"\n"+
				       	           "2. subtractHex"+"\n"+
				     	           "3. multiplyHex"+"\n"+
					               "4. divideHex"+"\n"+
					               "5. isLessThan"+"\n"+
					               "6. isGreaterThan"+"\n"+
					               "7. isEqual");
			    int menu= in.nextInt();
			    switch(menu) {
			    case 1:
				   System.out.println(calculate.add(hexFirst, hexSecond));
				   break;
			    case 2:
				   System.out.println(calculate.subtract(hexFirst, hexSecond));
				   break;
			    case 3:
				   System.out.println(calculate.multiply(hexFirst, hexSecond));
				   break;
			    case 4:
				   System.out.println(calculate.divide(hexFirst, hexSecond));
				   break;
			    case 5:
					   System.out.println(calculate.isLessThan(hexFirst, hexSecond));
					   break;
			    case 6:
					   System.out.println(calculate.isGreaterThan(hexFirst, hexSecond));
					   break;					   
			    case 7:
					   System.out.println(calculate.isEqual(hexFirst, hexSecond));
					   break;
			    default:
				   System.out.println("Wrong choice");
				   break;
			    }
			}
			else {
				System.out.println("Wrong hex values");
			}
			System.out.println("Do you want to continue? true if yes/ false if no");
			loop = in.nextBoolean();
		}while(loop);
	}
}
