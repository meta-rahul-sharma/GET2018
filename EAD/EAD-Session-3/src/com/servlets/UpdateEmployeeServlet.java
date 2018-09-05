package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to update employee in table employee_details of database employee and support UpdateEmployeeDetailsServlet in this process
 * @author Rahul
 * Creation Date: 30/08/2018
 */
@SuppressWarnings("serial")
public class UpdateEmployeeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Show All Employee</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Show All Employee</h1>");
		out.println("<form action = 'UpdateEmployeeDetails'>");
		out.println("<table align='center' cellspacing='30px'>");
		
		out.println("<tr>");
		out.println("<td>First Name</td>");
		out.println("<td><input type ='text' value= '"+ req.getParameter("firstName")+ "' name = 'FirstName' />");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Last Name</td>");
		out.println("<td><input type ='text' value= '"+ req.getParameter("lastName")+ "' name = 'LastName' />");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Email</td>");
		out.println("<td><input type ='text' value= '"+ req.getParameter("email")+ "' name = 'Email' />");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Age</td>");
		out.println("<td><input type ='text' value= '"+ req.getParameter("age")+ "' name = 'Age' />");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><input type ='submit' value= 'submit' />");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}