import java.util.Scanner;
/**
 * performs operation related to the grades of students like average, maxGrade etc
 * @author Rahul-Sharma
 *
 */
public class MarkSheet {
	double studentGrades[];
	int noOfStudents;
	
	/**
	 * constructor of MarkSheet class giving input to string variables
	 * @param noOfStudents
	 */
	public MarkSheet(int noOfStudents) {
		this.noOfStudents = noOfStudents;
		if(noOfStudents > 0) {
			studentGrades = new double[noOfStudents];
		} else {
			System.out.println("Wrong no. of Students passed as argument");
		}
	}
	
	/**
	 * intializing marks for students 
	 */
	void initializeMarks(int[] marks) {
		//Scanner input = new Scanner(System.in);
		for (int i = 0; i < noOfStudents; i++) {
			//System.out.println("Enter the marks for Student " + (i + 1) + " between 0 to 100");
			if(marks[i] >= 0 && marks[i] <= 100) {
				studentGrades[i] = marks[i]; 
			} else {
				throw new AssertionError();
			}
					//= input.nextDouble(); 
		}
	}
	
	/**
	 * calculate average grade of all students
	 * @return averageGrade
	 * @throws ArithmeticException
	 */
	double averageOfGrades() throws ArithmeticException {
		double averageGrades = 0;
		for (int i = 0; i < noOfStudents; i++) {
			averageGrades = averageGrades + studentGrades[i];
		}
		return (double)averageGrades / noOfStudents;
	}
	
	/**
	 * 
	 * @return maximum grade around all students
	 * @throws ArithmeticException
	 */
	double maximumGrade() {
		double maxGrade = studentGrades[0];
		for (int i = 1; i < noOfStudents; i++) {
			if (maxGrade < studentGrades[i]) {
				maxGrade = studentGrades[i];
			}
		}
		return maxGrade;
	}
	
	/**
	 * 
	 * @return minimum grade around all students
	 * @throws ArithmeticException
	 */
	double minimumGrade() {
		double minGrade = studentGrades[0];
		for (int i = 1; i < noOfStudents; i++) {
			if (minGrade > studentGrades[i]) {
				minGrade = studentGrades[i];
			}
		}
		return minGrade;
	}
	
	/**
	 * 
	 * @return percentage of student passed in double
	 * @throws ArithmeticException
	 */
	double percentOfStudentsPass() throws ArithmeticException {
		int noOfPassedStudents = 0;
		for (int i = 0; i < noOfStudents; i++) {
			if (studentGrades[i] >= 40) {
				noOfPassedStudents++;
			}
		}
		return (double)noOfPassedStudents / noOfStudents * 100;
	}
	
	/**
	 * handle range of marks btw 0-100
	 * @return if grade between range
	 * @throws ArithmeticException
	 */
	boolean checkEnteredGrades() {
		for (int i = 0; i < noOfStudents; i++) {
			if (studentGrades[i] > 100 || studentGrades[i] < 0) {
				return true;
			}
		}
		return false;
	}
}
