import static org.junit.Assert.*;

import org.junit.Test;


public class TestMarkJunit {

	@Test
	public void testMarkSheet() {
		int[] marks = new int[] { 45, 22, 67, 78, 89};
		MarkSheet mark = new MarkSheet(marks.length);
		mark.initializeMarks(marks);
		double averageOfGrade = mark.averageOfGrades();
		double maximumGrade = mark.maximumGrade();
		double minimumGrade = mark.minimumGrade();
		double percentOfStudentsPass = mark.percentOfStudentsPass();
		assertEquals(60.2, averageOfGrade, 0.001);
		assertEquals(89.0, maximumGrade, 0.001);
		assertEquals(22.0, minimumGrade, 0.001);
		assertEquals(80.0, percentOfStudentsPass, 0.001);
	}
	
	@Test(expected = AssertionError.class)
	public void testMarkSheet1() {
		int[] marks = new int[] { 45, 22, 67, 108, 89};
		MarkSheet mark = new MarkSheet(marks.length);
		mark.initializeMarks(marks);
		double averageOfGrade = mark.averageOfGrades();
		double maximumGrade = mark.maximumGrade();
		double minimumGrade = mark.minimumGrade();
		double percentOfStudentsPass = mark.percentOfStudentsPass();
		assertEquals(60.2, averageOfGrade, 0.001);
		assertEquals(89.0, maximumGrade, 0.001);
		assertEquals(22.0, minimumGrade, 0.001);
		assertEquals(80.0, percentOfStudentsPass, 0.001);
	}

}
