package com.metacube.counsellingprocess;

import java.io.IOException;

import com.metacube.queue.QueueException;

/**
 * Used for running Program Class Methods
 * @author Rahul
 * Creation Date: 5/8/2018
 */
public class TestProgram {
	
	/**
	 * Used for Initializing all the methods
	 * @param args
	 * @throws QueueException 
	 */
	public static void main(String args[]) throws QueueException {
		try {
			Program program = new Program(
					"Book1.xlsx");
			program.getProgramList();
			program.getStduentListWithSubjects();
			program.generateExcelSheet();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
