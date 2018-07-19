package shopping;
import java.util.Scanner;
public class Main {
	private static Scanner in;

	public static void main(String args[]) {
		ShoppinCart cart = new ShoppinCart();
		cart.initializeProductDetails();
		in = new Scanner(System.in);
		boolean continue_loop;
		do {
			System.out.println("Enter choice:"+"\n"+"1. showProducts:"+"\n"+"2. cartMenu");
			int choose= in.nextInt();
			switch(choose) {
			case 1:
				cart.showProducts();
				break;
			case 2:
				cart.menu();
				break;
			default:System.out.println("Entered Wrong choice");
			}
			System.out.println("choose false to stop & true to continue");
			continue_loop=in.nextBoolean();
		}while(continue_loop);
	}
}
