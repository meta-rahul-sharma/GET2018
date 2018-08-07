package com.metacube.graphicslibrary;

import java.util.Date;
import java.util.List;

/**
 * Square class which implements Shape class
 * @author Rahul Sharma
 * Creation Date: 31/7/2018
 */
public class Square implements Shape {
	private Point origin;
	private double side;
	private int representSide = 0;
	private Date date;
	private long timeStamp;
	
	/**
	 * Construction of Square Class initializing values
	 * @param origin
	 * @param parameters
	 */
	public Square(Point origin, List<Integer> parameters) {
		this.origin = origin;
		side = parameters.get(representSide);
		date = new Date();
		timeStamp = date.getTime();
		if(origin.getX() + side > 1920 || origin.getY() + side > 1080) {
			throw new RuntimeException("Rectangle is out of Screen");
		}
	}
	
	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
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
		if(origin.getX() <= enclosed.getX() && origin.getX() + side >= enclosed.getX() 
				&& origin.getY() <= enclosed.getY() && origin.getY() + side >= enclosed.getY()) {
			pointEnclosed = true;
		}
		return pointEnclosed;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.square;
	}

	@Override
	public long getTimeStamp() {
		return timeStamp;
	}
}