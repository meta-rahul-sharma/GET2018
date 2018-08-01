package com.metacube.graphicslibrary;

import java.util.ArrayList;
import java.util.List;

import com.metacube.graphicslibrary.Shape.ShapeType;

/**
 * 
 * @author Rahul Sharma
 * Creation Date: 31/7/2018
 */
public class Screen {
	List<Shape> shapes = new ArrayList<Shape>();

	public void addShape(ShapeType shapeType, Point point,
			List<Integer> parameters) {

		ShapeFactory factory = new ShapeFactory();
		shapes.add(factory.createShape(shapeType, point, parameters));
	}

	/**
	 * To delete shape from screen by index of shapes List
	 * @param index
	 */
	public void deleteShape(int index) {
		if (index < shapes.size()) {
			shapes.remove(index);
		}
	}

	/**
	 * To delete A specific ShapeType which are referenced by Shape
	 * interface
	 * @param shapeType
	 */
	public void deleteShapeOfShapeType(ShapeType shapeType) {
		for (int index = 0; index < shapes.size(); index++) {
			if (shapes.get(index).getShapeType() == shapeType) {
				shapes.remove(index);
			}
		}
	}

	/**
	 * To check that given point is enclosed in
	 * all shapes or not
	 * @param point
	 * @return list of Shape where user point is enclosed
	 */
	public List<Shape> isPointEnclosed(Point point) {
		List<Shape> isPointEnclosed = new ArrayList<Shape>();
		for (int index = 0; index < shapes.size(); index++) {
			if (shapes.get(index).isPointEnclosed(point)) {
				isPointEnclosed.add(shapes.get(index));
			}
		}
		return isPointEnclosed;
	}

	/**
	 * @return Shape list by sorting by area
	 */
	public ArrayList<Shape> ascendingInArea() {
		ArrayList<Shape> sortedShapes = new ArrayList<Shape>(shapes);
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getArea() > sortedShapes.get(j + 1)
						.getArea()) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * @return Shape list by sorting by perimeter
	 */
	public ArrayList<Shape> ascendingInPerimeter() {
		ArrayList<Shape> sortedShapes = new ArrayList<Shape>(shapes);
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getPerimeter() > sortedShapes
						.get(j + 1).getPerimeter()) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * @return Shape list by sorting by time of creation
	 */
	public ArrayList<Shape> ascendingInTimestamp() {
		ArrayList<Shape> sortedShapes = new ArrayList<Shape>(shapes);
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getTimeStamp()
						.after(sortedShapes.get(j + 1).getTimeStamp())) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * @return Shape list by sorting by distance of origin to (0, 0)
	 * coordinate
	 */
	public List<Shape> ascendingInOriginDistance() {
		ArrayList<Shape> sortedShapes = new ArrayList<Shape>(shapes);
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				double originDistanceJ = Math.sqrt(Math.pow(sortedShapes.get(j)
						.getOrigin().getX(), 2)
						+ Math.pow(sortedShapes.get(j).getOrigin().getY(), 2));
				double originDistanceJ1 = Math.sqrt(Math.pow(
						sortedShapes.get(j + 1).getOrigin().getX(), 2)
						+ Math.pow(sortedShapes.get(j + 1).getOrigin().getY(),
								2));
				if (originDistanceJ > originDistanceJ1) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	public List<Shape> getShapes() {
		return shapes;
	}
}