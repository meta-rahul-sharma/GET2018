package com.metacube.graphicslibrary;
import java.util.Date;
import java.util.List;


public class Circle implements Shape {
	private Point center;
	private Point origin;
	private double radius;
	private int representRadius = 0;
	private Date timeStamp;
	
	public Circle(Point center, List<Integer> parameters) {
		this.center = center;
		radius = parameters.get(representRadius);
		timeStamp = new Date();
		computeOrigin();
	}
	
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point enclosed) {
		boolean pointEnclosed = false;
		if (Math.pow(origin.getX() - enclosed.getX(), 2)
				+ Math.pow(origin.getY() - enclosed.getY(), 2) <= Math
					.pow(radius, 2)) {
			pointEnclosed = true;
		}
		return pointEnclosed;
	}
	
	private void computeOrigin() {
		double valueOfX1;
		double valueOfX2;
		double valueOfY;
		double A;
		double B;
		double C;
		double slope = center.getY() / center.getX();
		A = Math.pow(slope, 2) + 1;
		B = -2 * (slope * center.getY() + center.getX());
		C = (Math.pow(center.getY(), 2) + Math.pow(center.getX(), 2) - Math
				.pow(radius, 2));
		double underRoot = Math.sqrt((Math.pow(B, 2) - 4 * A * C));
		valueOfX1 = (-B + underRoot) / (2 * A);
		valueOfX2 = (-B - underRoot) / (2 * A);
		if (valueOfX1 <= center.getX()) {
			valueOfY = slope * valueOfX1;
			origin = new Point(valueOfX1, valueOfY);
		} else if (valueOfX2 <= center.getX()) {
			valueOfY = slope * valueOfX2;
			
			origin = new Point(valueOfX2, valueOfY);
		}
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.circle;
	}

	@Override
	public Date getTimeStamp() {
		return timeStamp;
	}
}
