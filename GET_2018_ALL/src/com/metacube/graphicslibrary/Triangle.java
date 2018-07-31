package com.metacube.graphicslibrary;

import java.util.Date;
import java.util.List;

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
	private Date timeStamp;

	public Triangle(Point origin, List<Integer> parameters) {
		this.origin = origin;
		height = parameters.get(representHeight);
		base = parameters.get(representBase);
		sideOne = parameters.get(representSide);
		timeStamp = new Date();
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

	@Override
	public boolean isPointEnclosed(Point enclosed) {
		boolean result = false;
		if(enclosed.getY() - slopeOne * enclosed.getX() <= origin.getY() - slopeOne * origin.getX() 
				&& enclosed.getY() - slopeSecond * enclosed.getX() <= pointOne.getY() - slopeSecond * pointOne.getX() 
				&& enclosed.getY() >= origin.getY()) {
			result = true;
		}
		/*System.out.println(origin.getY() - slopeOne * origin.getX());
		System.out.println(pointOne.getY() - slopeSecond * pointOne.getX());
		System.out.println(enclosed.getY() - slopeOne * enclosed.getX() <= origin.getY() - slopeOne * origin.getX() );
		System.out.println(enclosed.getY() - slopeSecond * enclosed.getX() <= pointOne.getY() - slopeSecond * pointOne.getX());
		System.out.println(enclosed.getY() >= origin.getY());*/
		
		return result;
	}

	private void computeOtherParameters() {
		double difference = Math.sqrt(Math.pow(sideOne, 2)
				- Math.pow(height, 2));
		double otherDifference = base - difference;
		
		sideSecond = Math.sqrt(Math.pow(height, 2)
				+ Math.pow(otherDifference, 2));
		pointOne = new Point(origin.getX() + difference, origin.getY() + height);
		pointSecond = new Point(origin.getX() + base, origin.getY());
		
		slopeOne = (pointOne.getY() - origin.getY()) / (pointOne.getX() - origin.getX());
		slopeSecond = (pointOne.getY() - pointSecond.getY()) / (pointOne.getX() - pointSecond.getX());
		
		/*System.out.println(slopeOne );
		System.out.println(slopeSecond );
		
		System.out.println(difference + " " + otherDifference + " " + sideSecond + " " + pointOne.getX() + " " + pointOne.getY() + " " + pointSecond.getX() + " " + pointSecond.getY());*/;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.triangle;
	}

	@Override
	public Date getTimeStamp() {
		return timeStamp;
	}

}
