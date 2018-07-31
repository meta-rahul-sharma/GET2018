package com.metacube.graphicslibrary;
import java.util.List;

import com.metacube.graphicslibrary.Shape.ShapeType;


public class ShapeFactory {
	
	public Shape createShape(ShapeType shapeType, Point point, List<Integer> parameters) {
		Shape shape = null;
		
		switch(shapeType) {
		case circle:
			shape = new Circle(point, parameters);
			break;
		case rectangle:
			shape = new Rectangle(point, parameters);
			break;
		/*case regularPolygon:
			return new RegularPolygon(point, parameters);
			break;*/
		case square:
			shape = new Square(point, parameters);
			break;
		case triangle:
			shape = new Triangle(point, parameters);
			break;
		default:
			break;
		
		}
		return shape;
	}
}
