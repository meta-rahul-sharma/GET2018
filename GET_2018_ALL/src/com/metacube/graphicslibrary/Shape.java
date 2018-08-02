package com.metacube.graphicslibrary;

import java.util.Date;

/**
 * Shape interface which is used for
 * method declaration
 * @author Rahul Sharma
 * Creation Date: 31/7/2018
 */
public interface Shape {
	
	public enum ShapeType {
		square, rectangle, circle, triangle;
	}
	
	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point enclosed);	
	public ShapeType getShapeType();
	public long getTimeStamp();
}
