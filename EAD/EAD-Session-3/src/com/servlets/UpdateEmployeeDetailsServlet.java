package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnection.Dao;

@SuppressWarnings("serial")
public class UpdateEmployeeDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		Dao dao = new Dao();
		PrintWriter out = res.getWriter();
		dao.updateEmployeeDetail(req.getParameter("FirstName"),
				req.getParameter("LastName"), req.getParameter("Email"),
				Integer.parseInt(req.getParameter("Age")));
		
		out.close();
	}
}
