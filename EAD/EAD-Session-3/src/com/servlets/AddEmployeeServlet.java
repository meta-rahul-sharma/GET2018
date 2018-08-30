package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnection.Dao;

/**
 * Servlet to add employee in table employee_details of database employee
 * @author Rahul
 * Creation Date: 30/08/2018
 */
@SuppressWarnings("serial")
public class AddEmployeeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Dao dao = new Dao();
		dao.AddEmployeeDetail(req.getParameter("firstName"),
				req.getParameter("lastName"), req.getParameter("email"),
				Integer.parseInt(req.getParameter("age")));
	}
}