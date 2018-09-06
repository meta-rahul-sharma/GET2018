package soap;

/**
 * To get area of traingle by sides using heron's formula
 * @author Rahul Sharma
 * Creation Date: 03/ 09/ 2018
 *
 */
public class Triangle {
	public double area(double a, double b, double c) {
		double halfPerimeter = ( a + b + c ) /2;
		double area = Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
		return area;
	}
}

