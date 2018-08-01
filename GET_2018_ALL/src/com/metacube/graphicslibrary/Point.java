package com.metacube.graphicslibrary;

/**
 * 
 * @author Rahul Sharma
 * Creation Date: 31/7/2018
 */
public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		if (x >= 0 && y >= 0 &&
				x <= 1920 && y <= 1080) {
			this.x = x;
			this.y = y;
		} else {
			throw new RuntimeException("Point not on Screen");
		}
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
