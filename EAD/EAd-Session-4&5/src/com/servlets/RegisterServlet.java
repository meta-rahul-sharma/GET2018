package com.servlets;

import java.io.IOException;
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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserFacade userFacade = UserFacade.getInstance();
		
		try {
			if (userFacade.registerUser(request.getParameter("regFirstName"), request.getParameter("regLastName"),
					Date.valueOf(request.getParameter("dob")),
					request.getParameter("regContact"), request.getParameter("regEmail"),
					request.getParameter("regPassword"), request.getParameter("organization"))) {
				HttpSession session = request.getSession();
				session.setAttribute("email", request.getParameter("regEmail"));
		        RequestDispatcher rd = request.getRequestDispatcher("/ProfileServlet");
		        rd.forward(request, response);
				
				System.out.println("Entry Successfull");
			} else {
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
