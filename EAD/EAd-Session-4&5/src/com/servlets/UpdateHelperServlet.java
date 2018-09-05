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

import com.facade.UserFacade;
import com.model.User;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class UpdateHelperServlet
 */
@WebServlet("/UpdateHelperServlet")
public class UpdateHelperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserFacade facade = UserFacade.getInstance();
		String email = request.getParameter("hiddenEmail");
		User user = null;
		try {
			user = facade.getUser(email);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println(email);
		System.out.println(request.getParameter("firstName")+ request.getParameter("lastName")+
						Date.valueOf(request.getParameter("dob"))+ request.getParameter("contact"));
		try {
			try {
				if(
						facade.updateUserInfo(request.getParameter("firstName"), request.getParameter("lastName"),
						Date.valueOf(request.getParameter("dob")), request.getParameter("contact"),
						user)) {
					request.setAttribute("email", email);
			        RequestDispatcher rd = request.getRequestDispatcher("/ProfileServlet");
			        rd.forward(request, response);
				} else {
					response.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
				}
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
			} catch (ParseException e) {
				response.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
		}
		System.out.println("Updated successfully");
	}

}
