package com.metacube.graphicslibrary;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.metacube.graphicslibrary.Shape.ShapeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Used for testing purpose of Shape interface and
 * function of Screen and other class Which are 
 * Implementing Shape
 * @author Rahul Sharma
 * Creation Date: 31/7/2018
 */
public class TestShape {

	private static Screen screen = new Screen();
	
	@BeforeClass
	public static void initialize() {
		screen.addShape(ShapeType.rectangle, new Point(7, 5), new ArrayList<Integer>(Arrays.asList(3, 15)));
		screen.addShape(ShapeType.triangle, new Point(5, 5), new ArrayList<Integer>(Arrays.asList(5, 10, 6)));
		screen.addShape(ShapeType.square, new Point(6, 5), new ArrayList<Integer>(Arrays.asList(7)));
		screen.addShape(ShapeType.circle, new Point(4, 5), new ArrayList<Integer>(Arrays.asList(4)));
	}
	
	@Test
	public void test() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(3);
		triParam.add(10);
		triParam.add(5);
		
		Triangle triangle = new Triangle(new Point(0, 0), triParam);
		assertEquals(true, triangle.isPointEnclosed(new Point(4, 2)));
	}
	
	@Test
	public void testIsPointEnclosed() {
		List<Shape> isPointEnclosed = screen.isPointEnclosed(new Point(6, 5));
		List<Shape> expected = new ArrayList<Shape>();
		expected.add(screen.getShapes().get(1));
		expected.add(screen.getShapes().get(2));
		expected.add(screen.getShapes().get(3));
		assertEquals(expected, isPointEnclosed);
	}
	
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}
	
	@Test
	public void testAscendingInTimestamp() {
		List<Shape> ascendingInTimestamp = screen.ascendingInTimestamp();
		assertEquals(screen.getShapes(), ascendingInTimestamp);
	}
	
	@Test
	public void testAscendingInOriginDistance() {
		List<Shape> ascendingInOriginDistance = screen.ascendingInOriginDistance();
		List<Shape> expected = new ArrayList<Shape>();
		expected.add(screen.getShapes().get(3));
		expected.add(screen.getShapes().get(1));
		expected.add(screen.getShapes().get(2));
		expected.add(screen.getShapes().get(0));
		assertEquals(expected, ascendingInOriginDistance);
	}
	
	@Test
	public void testAscendingInArea() {
		List<Shape> ascendingInArea = screen.ascendingInArea();
		List<Shape> expected = new ArrayList<Shape>();
		expected.add(screen.getShapes().get(1));
		expected.add(screen.getShapes().get(0));
		expected.add(screen.getShapes().get(2));
		expected.add(screen.getShapes().get(3));
		assertEquals(expected, ascendingInArea);
	}
	
	@Test
	public void testAscendingInPerimeter() {
		List<Shape> ascendingInPerimeter = screen.ascendingInPerimeter();
		List<Shape> expected = new ArrayList<Shape>();
		expected.add(screen.getShapes().get(1));
		expected.add(screen.getShapes().get(3));
		expected.add(screen.getShapes().get(2));
		expected.add(screen.getShapes().get(0));
		assertEquals(expected, ascendingInPerimeter);
	}

	@Test
	public void testDeleteShape() {
		Screen testDelete = new Screen();
		testDelete.addShape(ShapeType.circle, new Point(6, 6), new ArrayList<Integer>(Arrays.asList(6)));
		testDelete.addShape(ShapeType.rectangle, new Point(9, 2), new ArrayList<Integer>(Arrays.asList(3, 5)));
		testDelete.addShape(ShapeType.circle, new Point(4, 5), new ArrayList<Integer>(Arrays.asList(2)));
		testDelete.deleteShape(1);
		assertEquals(2, testDelete.getShapes().size());
	}
	
	@Test
	public void testDeleteShapeOfShapeType() {
		Screen testDelete = new Screen();
		testDelete.addShape(ShapeType.circle, new Point(6, 6), new ArrayList<Integer>(Arrays.asList(6)));
		testDelete.addShape(ShapeType.rectangle, new Point(9, 2), new ArrayList<Integer>(Arrays.asList(3, 5)));
		testDelete.addShape(ShapeType.circle, new Point(4, 5), new ArrayList<Integer>(Arrays.asList(2)));
		testDelete.deleteShapeOfShapeType(ShapeType.circle);
		assertEquals(1, testDelete.getShapes().size());
	}
	
	@Test
	public void testPointNotOnScreen() {
		try{
			Point point = new Point(-1, -1);
		} catch(RuntimeException ex) {
			assertEquals("Point not on Screen", ex.getMessage());
		}
	}
	
	@Test
	public void testCircleOutOfScreenException() {
		try{
			Screen circleOutOfScreen = new Screen();
			circleOutOfScreen.addShape(ShapeType.circle, new Point(3, 3), new ArrayList<Integer>(Arrays.asList(4)));
			
		} catch(RuntimeException ex) {
			assertEquals("Circle out of Screen", ex.getMessage());
		}
	}
	
	@Test
	public void testCircleOutOfScreenException1() {
		try{
			Screen circleOutOfScreen = new Screen();
			circleOutOfScreen.addShape(ShapeType.circle, new Point(1918, 3), new ArrayList<Integer>(Arrays.asList(4)));
			
		} catch(RuntimeException ex) {
			assertEquals("Circle out of Screen", ex.getMessage());
		}
	}
	
	@Test
	public void testTriangleOutOfScreenException() {
		try{
			Screen triangleOutOfScreen = new Screen();
			triangleOutOfScreen.addShape(ShapeType.triangle, new Point(1908, 1073), new ArrayList<Integer>(Arrays.asList(7, 4, 8)));
			
		} catch(RuntimeException ex) {
			assertEquals("Triangle out of Screen", ex.getMessage());
		}
	}
}
