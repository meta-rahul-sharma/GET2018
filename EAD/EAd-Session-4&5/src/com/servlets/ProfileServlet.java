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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = (String) request.getAttribute("email");
		UserDao dao = UserDao.getInstance();

		try {

			User user = dao.getUser(email);
			System.out.println(user.getFirstName());
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Profile</title>");
			out.print("<link href = 'Design.css' rel = 'stylesheet'>");
			out.print("</head>");
			out.print("<body><table width = '100%' class = 'header'>");
			out.print("<tr><td><img src='html.png' id='logo' height = 50px></td>");
			out.print("<td align = 'right'><span style = 'color : white' id = 'username'>"
					+ user.getFirstName() + " " + user.getLastName() + "  |  "
					+ "</span><a href = 'Logout'>Logout</a></td>");
			out.print("</tr></table>");
			out.print("<table width = '100%'><tr><td>");
			out.print("<h2>User Details</h2><br/><br/>");
			out.print("<table width = '50%' align = 'center'><tr>");
			out.print("<td><p><strong>First Name:</strong></p></td>");
			out.print("<td><p>" + user.getFirstName() + "</p></td></tr>");
			out.print("<tr><td><p><strong>Last Name:</strong></p></td>");
			out.print("<td><p>" + user.getLastName() + "</p></td></tr>");
			out.print("<tr><td><p><strong>Date Of Birth:</strong></p></td>");
			out.print("<td><p>" + user.getDob() + "</p></td></tr>");
			out.print("<tr><td><p><strong>Email:</strong></p></td>");
			out.print("<td><p>" + user.getEmail() + "</p></td></tr>");
			out.print("<tr><td><p><strong>Contact Number:</strong></p></td>");
			out.print("<td><p>" + user.getContact() + "</p></td></tr>");
			out.print("<tr><td><p><strong>Organization:</strong></p></td>");
			out.print("<td><p>" + user.getOrganization() + "</p></td></tr>");
			out.print("<tr><td><a href='UpdateServlet?email=" + user.getEmail()
					+ "&fname=" + user.getFirstName() + "&lname="
					+ user.getLastName() + "&age=" + user.getDob()
					+ "&contact=" + user.getContact() + "&organization="
					+ user.getOrganization() + "'>Edit Details</a></td></tr></table></td>");
			out.print("<td><table width = '50%' align = 'center'><tr><td>");
			out.print("<h1>Welcome</h1>");
			out.print("</td></tr>");
			out.print("</table></body></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
