package com.metacube.graphicslibrary;

import java.util.Date;
import java.util.List;

/**
 * Rectangle class which implements Shape class
 * @author Rahul Sharma
 * Creation Date: 31/7/2018
 */
public class Rectangle implements Shape {
	private Point origin;
	private double height, width;
	private int representHeight = 0;
	private int representWidth = 1;
	private Date timeStamp;

	/**
	 * Construction of Rectangle Class initializing values
	 * @param origin
	 * @param parameters
	 */
	public Rectangle(Point origin, List<Integer> parameters) {
		this.origin = origin;
		height = parameters.get(representHeight);
		width = parameters.get(representWidth);
		timeStamp = new Date();
		if(origin.getX() + width > 1920 || origin.getY() + height> 1080) {
			throw new RuntimeException("Rectangle is out of Screen");
		}
	}

	@Override
	public double getArea() {
		return height * width;
	}

	@Override
	public double getPerimeter() {
		return 2 * height + 2 * width;
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
		if (origin.getX() <= enclosed.getX()
				&& origin.getX() + width >= enclosed.getX()
				&& origin.getY() <= enclosed.getY()
				&& origin.getY() + height >= enclosed.getY()) {
			pointEnclosed = true;
		}
		return pointEnclosed;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.rectangle;
	}

	@Override
	public Date getTimeStamp() {
		return timeStamp;
	}
}
