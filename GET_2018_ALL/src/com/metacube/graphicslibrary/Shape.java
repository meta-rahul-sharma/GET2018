package com.metacube.graphicslibrary;

import java.util.Date;

public interface Shape {
	
	public enum ShapeType {
		square, rectangle, circle, triangle/*, regularPolygon*/;
	}
	
	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point enclosed);	
	public ShapeType getShapeType();
	public Date getTimeStamp();
}
