package com.metacube.counsellingprocess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.metacube.queue.ListQueue;
import com.metacube.queue.Queue;
import com.metacube.queue.QueueException;

/**
 * Used for implementation of the counseling process of a College
 * @author Rahul
 * Creation Date: 5/8/2018
 */
public class Program {
	private XSSFSheet firstSheet;
	private XSSFSheet secondSheet;
	private String fileName;
	private List<String> programName = new ArrayList<String>();
	private List<Integer> seatAvailable = new ArrayList<Integer>();
	private Queue<String> studentName = new ListQueue<String>(10);
	private Queue<String> studentCourse = new ListQueue<String>(10); 

	/**
	 * constructor which have filename as argument
	 * this file contain data of following:
	 * 1. program and number of seats
	 * 2. Name of candidate with ranking in descending order
	 * and name of courses they want with choic in desceding
	 * order
	 * @param fileName
	 * @throws IOException
	 */
	public Program(String fileName) throws IOException {
		this.fileName = fileName;
		File program = new File(this.fileName);
		FileInputStream inStream = new FileInputStream(program);

		XSSFWorkbook woorkbook = new XSSFWorkbook(inStream);
		firstSheet = woorkbook.getSheetAt(0);
		secondSheet = woorkbook.getSheetAt(1);
	}

	/**
	 * Used for getting program and number of seats
	 */
	public void getProgramList() {
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			
			Cell programName = nextRow.getCell(0);
			Cell seatAvailable = nextRow.getCell(1);
			
			this.programName.add(programName.getStringCellValue());
			this.seatAvailable.add((int) seatAvailable.getNumericCellValue());
		}
	}
	
	/**
	 * For getting student list in queue and allocating
	 * courses to them
	 * @throws QueueException 
	 */
	public void getStduentListWithSubjects() throws QueueException {
		Iterator<Row> iterator = secondSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			for (int i = 0, j = nextRow.getLastCellNum(); i < j; i++) {
				Cell cell = nextRow.getCell(i);
				if (i == 0) {
					String name = cell.getStringCellValue();
					studentName.addItem(name);
				} else {
					String course = cell.getStringCellValue();
					if(searchAndSet(course)) {
						break;
					}
				}
				
				if(i == j - 1) {
					studentCourse.addItem("none");
				}
			}
		}
	}
	
	/**
	 * To search if student program is available or not
	 * if available then allocating him or her that program
	 * @param course
	 * @return true if allocation successful 
	 * @throws QueueException 
	 */
	private boolean searchAndSet(String course) throws QueueException {
		boolean result = false;
		for(int i = 0; i < programName.size(); i++) {
			String program = programName.get(i);
			int seat = seatAvailable.get(i);
			if(course.equals(program) &&
					seat > 0) {
				seatAvailable.set(i, seat - 1);
				studentCourse.addItem(course);
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * To generate excel sheet which contain data of 
	 * student name and program he or she get allocated
	 * @throws IOException
	 * @throws QueueException 
	 */
	public void generateExcelSheet() throws IOException, QueueException {
		FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("selected-students");
		Font headFont = workbook.createFont();
		
		int row = 0;
		while(!studentName.isQueueEmpty()) {
			Row headerRow = sheet.createRow(row++);
			Cell coulumnFirstCell = headerRow.createCell(0);
			coulumnFirstCell.setCellValue(studentName.deleteItem());
			Cell coulumnSecondCell = headerRow.createCell(1);
			coulumnSecondCell.setCellValue(studentCourse.deleteItem());
		}
		workbook.write(fileOut);
	}
}
