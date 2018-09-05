package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =  (String) request.getParameter("hiddenEmail");
		UserDao dao = UserDao.getInstance();
		User user = null;
		try {
			user = dao.getUser(email);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(
				"<img name = 'imageOfUser'src=''><form action='FriendServlet' method='get'><input type='hidden' name='email' value='"
						+ email + "'/><input type='submit' value='Friends'></form><a href='LogoutServlet'>Logout</a> ");
		out.print("<form action='UpdateHelper' method='post'>" + "<h1 align=''center>Profile</h1><br />"
				+ "<table cellpadding='5'><tr>" + "<th align='left'>First Name :</th>"
				+ "<td><input type='text' name = 'firstName' value= '" + user.getFirstName() + "'/></td></tr>"
				+ "<th align='left'>Last Name :</th>" + "<td><input type='text' name = 'lastName' value= '"
				+ user.getLastName() + "'/></td></tr>" + "<tr><th align='left'>Date of Birth :</th>"
				+ "<td><input type='date' name='dob' value='" + user.getDob() + "'/></td></tr>"
				+ "<tr><th align='left'>Contact No. :</th>" + "<td><input type='number' name='contact' value='"
				+ user.getContact() + "'/></td></tr>" + "<tr><th align='left'>Email :</th>"
				+ "<td><input type='email' name='email' value='" + user.getEmail() + "' readonly/></td></tr>"
				+ "<tr><th align='left'>Organization :</th>"
				+ "<td><input type='text' name = 'organization' value='" + user.getOrganization()
				+ "' readonly /></td>" + "</tr><tr><td><input type='submit' value='Edit Details'></td></tr></table>"
				+ "<input type='hidden' name='hiddenEmail' value='" + email + "'/></form>");
	}

}
