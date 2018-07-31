package com.metacube.graphicslibrary;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.metacube.graphicslibrary.Shape.ShapeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TestShape {

	private static Screen screen = new Screen();
	
	@BeforeClass
	public static void initialize() {
		screen.addShape(ShapeType.rectangle, new Point(4, 5), new ArrayList<Integer>(Arrays.asList(5, 4)));
		screen.addShape(ShapeType.triangle, new Point(4, 5), new ArrayList<Integer>(Arrays.asList(5, 4, 3)));
		screen.addShape(ShapeType.square, new Point(4, 5), new ArrayList<Integer>(Arrays.asList(5)));
		screen.addShape(ShapeType.circle, new Point(4, 5), new ArrayList<Integer>(Arrays.asList(4)));
		screen.addShape(ShapeType.circle, new Point(6, 6), new ArrayList<Integer>(Arrays.asList(6)));
		screen.addShape(ShapeType.rectangle, new Point(9, 2), new ArrayList<Integer>(Arrays.asList(3, 5)));
		screen.addShape(ShapeType.circle, new Point(4, 5), new ArrayList<Integer>(Arrays.asList(2)));
		screen.addShape(ShapeType.triangle, new Point(4, 5), new ArrayList<Integer>(Arrays.asList(7, 4, 3)));
		screen.addShape(ShapeType.rectangle, new Point(2, 3), new ArrayList<Integer>(Arrays.asList(6, 4)));
		screen.addShape(ShapeType.square, new Point(2, 4), new ArrayList<Integer>(Arrays.asList(3)));
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
		assertEquals(screen.getShapes(), ascendingInOriginDistance);
	}

	/*
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}
	
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}
	
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}
	
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}
	
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}
	
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}
	
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}
	
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}
	
	@Test
	public void testRectangle() {
		List<Integer> triParam = new ArrayList<Integer>();
		triParam.add(1);
		
		Circle circle = new Circle(new Point(5, 5), triParam);
		assertEquals(true, circle.isPointEnclosed(new Point(5, 4.5)));
	}*/
}
