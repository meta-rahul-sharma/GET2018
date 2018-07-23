import static org.junit.Assert.*;

import org.junit.Test;

public class TestArea {

	@Test
	public void testCircle() {
		Area area = new Area();
		double circleArea = area.areaCircle(25);
		assertEquals(3.14 * 25 * 25, circleArea, 0.001);

	}

	@Test
	public void testTriangle() {
		Area area = new Area();
		double triangleArea = area.areaTriangle(25, 34);
		assertEquals(0.5 * 25 * 34, triangleArea, 0.001);
	}

	@Test
	public void testSquare() {
		Area area = new Area();
		double squareArea = area.areaSquare(25);
		assertEquals(25 * 25, squareArea, 0.001);
	}

	@Test
	public void testRectangle() {
		Area area = new Area();
		double rectangleArea = area.areaRectangle(25, 56);
		assertEquals(25 * 56, rectangleArea, 0.001);
	}

}
