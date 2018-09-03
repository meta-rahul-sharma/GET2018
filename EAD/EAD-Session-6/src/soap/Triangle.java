package soap;


public class Triangle {
	public double area(double a, double b, double c) {
		double halfPerimeter = ( a + b + c ) /2;
		double area = Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
		return area;
	}
}

