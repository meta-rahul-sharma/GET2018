package com.metacube.graphicslibrary;
import java.util.List;

import com.metacube.graphicslibrary.Shape.ShapeType;

/**
 * Used for returning objects of different class like:
 * 1. Rectangle
 * 2. Circle
 * 3. Square
 * 4. Triangle
 * with reference of Shape class
 * @author Rahul Sharma
 * Creation Date: 31/7/2018
 */
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
