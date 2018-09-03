package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.UserFacade;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserFacade userFacade = UserFacade.getInstance();
		PrintWriter out = response.getWriter();
		try {
			if (userFacade.authenticateUser(request.getParameter("logEmail"), request.getParameter("logPassword"))) {
				HttpSession session = request.getSession();
				session.setAttribute("email", request.getParameter("logEmail"));
		        RequestDispatcher rd = request.getRequestDispatcher("/ProfileServlet");
		        rd.forward(request, response);
				
				System.out.println("Login Successfull");
			} else {
				 RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
			     rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
