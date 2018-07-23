import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * used for testing marksheet class
 * 
 * @author Rahul-Sharma
 *
 */
public class TestMarkSheet {
	public static void main(String args[]) {
		DecimalFormat decimalUptoTwo = new DecimalFormat(".##");// used for
																// decimal upto
																// 2 of double
		int select;

		int[] marks = new int[] { 45, 22, 67, 78, 89 };
		MarkSheet marksheetOfStudents = new MarkSheet(marks.length);
		marksheetOfStudents.initializeMarks(marks);

		if (marksheetOfStudents.checkEnteredGrades()) {
			System.out.println("Entered grades should only be from 0 to 100");
			System.exit(1);
		}
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out
					.println("Enter the choice\n1. Average of Grades\n2.Maximum of Grades\n"
							+ "3.Minimum of Grades\n4.Percent of Students Passed\n5.Exit");

			select = input.nextInt();
			switch (select) {
			case 1:
				double averageMarks = marksheetOfStudents.averageOfGrades();
				System.out.println("Average of Grades:- "
						+ decimalUptoTwo.format(averageMarks));
				break;

			case 2:
				double maxMarks = marksheetOfStudents.maximumGrade();
				System.out.println("Maximum of Grades:- "
						+ decimalUptoTwo.format(maxMarks));
				break;

			case 3:
				double minMarks = marksheetOfStudents.minimumGrade();
				System.out.println("Minimum of Grades:- "
						+ decimalUptoTwo.format(minMarks));
				break;

			case 4:
				double studentPassedPercentage = marksheetOfStudents
						.percentOfStudentsPass();
				System.out.println("Percentage of Passed Students:- "
						+ decimalUptoTwo.format(studentPassedPercentage));
				break;

			case 5:
				System.exit(1);

			default:
				System.out.println("Wrong Input");
				break;
			}
		}
	}
}
