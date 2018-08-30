package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnection.Dao;
import com.pojo.Employee;

@SuppressWarnings("serial")
public class ShowAllEmployeesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		Dao dao = new Dao();
		List<Employee> employees = dao.showAllEmployee();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Show All Employee</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Show All Employee</h1>");
		out.println("<table align='center' cellspacing='30px'>");
		out.println("<th>");
		out.println("<td>First Name</td>");
		out.println("<td>Last Name</td>");
		out.println("<td>Email</td>");
		out.println("<td>Age</td>");
		out.println("</th>");
		int rowCount = 1;
		for (Employee employee : employees) {
			out.println("<tr>");
			out.println("<td>" + rowCount + "</td>");
			out.println("<td>" + employee.getFirstName() + "</td>");
			out.println("<td>" + employee.getLastName() + "</td>");
			out.println("<td>" + employee.getEmail() + "</td>");
			out.println("<td>" + employee.getAge() + "</td>");
			out.println("<td><a href='UpdateEmployee?email=" + employee.getEmail()
					+ "&firstName=" + employee.getFirstName() + "&lastName="
					+ employee.getLastName() + "&age=" + employee.getAge()
					+ "'>Edit</a></td></tr>");
			rowCount++;
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
