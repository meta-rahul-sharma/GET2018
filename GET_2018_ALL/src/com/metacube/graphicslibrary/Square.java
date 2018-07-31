package com.metacube.graphicslibrary;

import java.util.Date;
import java.util.List;

public class Square implements Shape {
	private Point origin;
	private double side;
	private int representSide = 0;
	private Date timeStamp;
	
	public Square(Point origin, List<Integer> parameters) {
		this.origin = origin;
		side = parameters.get(representSide);
		timeStamp = new Date();
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
	public Date getTimeStamp() {
		return timeStamp;
	}
}
