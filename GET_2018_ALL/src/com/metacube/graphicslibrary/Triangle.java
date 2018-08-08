package com.metacube.graphicslibrary;

import java.util.Date;
import java.util.List;

/**
 * Triangle class which implements Shape class
 * 
 * @author Rahul Sharma Creation Date: 31/7/2018
 */
public class Triangle implements Shape {
	private Point origin;
	private Point pointOne;
	private Point pointSecond;
	private double height;
	private double base;
	private double sideOne;
	private double sideSecond;
	private double slopeOne;
	private double slopeSecond;
	private int representHeight = 0;
	private int representBase = 1;
	private int representSide = 2;
	private Date date;
	private long timeStamp;

	/**
	 * Construction of Triangle Class initializing values
	 * 
	 * @param origin
	 * @param parameters
	 */
	public Triangle(Point origin, List<Integer> parameters) {
		this.origin = origin;
		height = parameters.get(representHeight);
		base = parameters.get(representBase);
		sideOne = parameters.get(representSide);

		if (sideOne < height) {
			throw new RuntimeException("Triangle values not as Specification");
		}
		date = new Date();
		timeStamp = date.getTime();
		computeOtherParameters();
	}

	@Override
	public double getArea() {
		return 0.5 * height * base;
	}

	@Override
	public double getPerimeter() {
		return base + sideOne + sideSecond;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	/**
	 * To check whether given point by user is Enclosed by shape or not
	 */
	@Override
	public boolean isPointEnclosed(Point enclosed) {
		boolean result = false;
		if (enclosed.getY() - slopeOne * enclosed.getX() <= origin.getY()
				- slopeOne * origin.getX()
				&& enclosed.getY() - slopeSecond * enclosed.getX() <= pointOne
						.getY() - slopeSecond * pointOne.getX()
				&& enclosed.getY() >= origin.getY()) {
			result = true;
		}
		return result;
	}

	/**
	 * In a Triangle there are three sides and three coordinates We are taking sideOne
	 * as the Leftmost side of base side We are taking sideSecond as the Rightmost side
	 * of base side The intersection of sideOne and sideSecond is the pointOne The
	 * intersection of sideSecond and base side is the pointSecond
	 */
	private void computeOtherParameters() {
		double difference = Math.sqrt(Math.pow(sideOne, 2)
				- Math.pow(height, 2));
		double otherDifference = base - difference;

		sideSecond = Math.sqrt(Math.pow(height, 2)
				+ Math.pow(otherDifference, 2));
		try {
			pointOne = new Point(origin.getX() + difference, origin.getY()
					+ height);
			pointSecond = new Point(origin.getX() + base, origin.getY());
		} catch (RuntimeException ex) {
			throw new RuntimeException("Triangle out of Screen");
		}

		slopeOne = (pointOne.getY() - origin.getY())
				/ (pointOne.getX() - origin.getX());
		slopeSecond = (pointOne.getY() - pointSecond.getY())
				/ (pointOne.getX() - pointSecond.getX());
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.triangle;
	}

	@Override
	public long getTimeStamp() {
		return timeStamp;
	}

}
