package com.metacube.graphicslibrary;

import java.util.Date;
import java.util.List;

/**
 * Circle class which implements Shape class
 * @author Rahul Sharma
 * Creation Date: 31/7/2018
 */
public class Circle implements Shape {
	private Point center;
	private Point origin;
	private double radius;
	private int representRadius = 0;
	private Date timeStamp;

	/**
	 * Construction of Circle Class initializing values
	 * @param center
	 * @param parameters
	 */
	public Circle(Point center, List<Integer> parameters) {
		this.center = center;
		radius = parameters.get(representRadius);
		timeStamp = new Date();
		if (center.getX() + radius > 1920 || center.getY() + radius > 1080
				|| center.getX() - radius < 0 || center.getY() - radius < 0) {
			throw new RuntimeException("Circle out of Screen");
		}
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

	/**
	 * To check whether given point by user is
	 * Enclosed by shape or not
	 */
	@Override
	public boolean isPointEnclosed(Point enclosed) {
		boolean pointEnclosed = false;
		if (Math.pow(center.getX() - enclosed.getX(), 2)
				+ Math.pow(center.getY() - enclosed.getY(), 2) <= Math.pow(
				radius, 2)) {
			pointEnclosed = true;
		}
		return pointEnclosed;
	}

	/**
	 * To compute origin point of circle 
	 * origin will considered to be a point
	 * on the circle that lies on the line 
	 * connecting the center of the circle
	 * to the origin of the screen
	 */
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