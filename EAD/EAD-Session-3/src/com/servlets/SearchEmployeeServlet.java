package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnection.Dao;
import com.pojo.Employee;

/**
 * Servlet to seach employee in table employee_details of database employee and display them
 * @author Rahul
 * Creation Date: 30/08/2018
 */
@SuppressWarnings("serial")
public class SearchEmployeeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Dao dao = new Dao();
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		Employee employee = dao.searchEmployee(req.getParameter("firstName").trim(), req.getParameter("lastName").trim());
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Search Employee Details</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Show All Employee</h1>");
		out.println("<table align='center' cellspacing='30px'>");
		out.println("<tr>");
		out.println("<td>First Name</td>");
		out.println("<td>Last Name</td>");
		out.println("<td>Email</td>");
		out.println("<td>Age</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + employee.getFirstName() + "</td>");
		out.println("<td>" + employee.getLastName() + "</td>");
		out.println("<td>" + employee.getEmail() + "</td>");
		out.println("<td>" + employee.getAge() + "</td>");
		out.println("</tr>");	
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
