/**
 * 
 * @author RAHUL SHARMA
 *
 */
public class Area {
	
	/**
	 * 
	 * @param height of triangle
	 * @param width of triangle
	 * @return area of triangle
	 */
	public double areaTriangle(double height, double width){
		return 0.5*height*width;
	}
	
	/**
	 * 
	 * @param height of rectangle
	 * @param width of rectangle
	 * @return area of rectangle
	 */
	public double areaRectangle(double height, double width){
		return height*width;
	}
	
	/**
	 * 
	 * @param side of square
	 * @return area of square
	 */
	public double areaSquare(double side){
		return side*side;
	}
	
	/**
	 * 
	 * @param radius of circle
	 * @return area of circle
	 */
	public double areaCircle(double radius){
		double pi = 3.14;
		return pi*radius*radius;
	}
}
