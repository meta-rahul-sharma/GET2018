import java.util.Scanner;
/**
 * 
 * @author Rahul Sharma
 *used to implement all methods of Area class
 */
public class AreaImplement {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		Area area = new Area();
		while (true) {
			System.out.println("Enter the choice\n1. Area of Triangle \n2. Area of Rectangle\n3. Area of Square\n4. Area of Circle\n5. Exit");
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("Enter height of Triangle");
				double heightOfTriangle = input.nextDouble();
				
				System.out.println("Enter width of Triangle");
				double widthOfTriangle = input.nextDouble();
				
				double areaOfTriangle = area.areaTriangle(heightOfTriangle, widthOfTriangle);
				System.out.println("Area of Triangle:- " + areaOfTriangle);
				break;
				
			case 2:
				System.out.println("Enter height of Rectangle");
				double heightOfRectangle = input.nextDouble();
				
				System.out.println("Enter width of Rectangle");
				double widthOfRectangle = input.nextDouble();
				
				double areaOfRectangle = area.areaRectangle(heightOfRectangle, widthOfRectangle);
				System.out.println("Area of Rectangle:- " + areaOfRectangle);
				break;
				
			case 3:
				System.out.println("Enter side of Square");
				double sideOfSquare = input.nextDouble();
				
				double areaOfSquare = area.areaSquare(sideOfSquare);
				System.out.println("Area of Square:- " + areaOfSquare);
				break;
				
			case 4:
				System.out.println("Enter radius of Circle");
				double radiusOfCircle = input.nextDouble();
				
				double areaOfCircle = area.areaCircle(radiusOfCircle);
				System.out.println("Area of Circle:- " + areaOfCircle);
				break;
				
			case 5:
				System.exit(1);
			
			default:
				System.out.println("Wrong Input");
			}
			
		}
	}
}
