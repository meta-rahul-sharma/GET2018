package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.UserFacade;
import com.model.User;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		UserFacade facade = UserFacade.getInstance();
		String filePath = getServletContext().getInitParameter("profileImage");
		File profileImage = new File(filePath + "\\" + email + ".jpg");

		try {

			User user = facade.getUser(email);
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Profile</title>");
			out.print("<link href = 'Design.css' rel = 'stylesheet'>");
			out.print("</head>");
			out.print("<body><table width = '100%' class = 'header'>");
			out.print("<tr><td><img src='html.png' id='logo' height = 50px></td>");
			out.print("<td align = 'right'><span style = 'color : white' id = 'username'>"
					+ user.getFirstName()
					+ " "
					+ user.getLastName()
					+ "  |  "
					+ "</span><a href = 'FriendServlet?email="
					+ user.getEmail()
					+ "'>Friends</a><span style = 'color : white'> | </span><a href = 'LogoutServlet'>Logout</a></td>");
			out.print("</tr></table>");
			out.print("<table width = '100%'><tr><td>");
			out.print("<table width = '50%' align = 'center'><tr>");
			out.print("<td align = 'center'><h2>User Details</h2><br/><br/></td></tr>");
			out.print("<tr><td><p><strong>First Name:</strong></p></td>");
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
			out.print("<tr><td><form action = 'Update' method = 'post'><input type='submit' value='Edit Details'>"
					+ "<input type='hidden' name='hiddenEmail' value= '"
					+ email + "'/></form></td></tr></table></td>");
			out.print("<td><table width = '50%' align = 'center'>"
					+ "<tr><td>");
			out.print("<h1>Welcome</h1>");
			out.print("</td></tr>");
			out.println("<tr><td><form action = 'SetProfileImageServlet' method='post' enctype = 'multipart/form-data'>"
					+ "<input type='hidden' name='hiddenEmail' value='"
					+ email
					+ "'/>");
			if (profileImage.exists()) {
				out.print("<img src='" + profileImage
						+ "' height = '30%'/><br>");
			} else {
				out.print("<img src='C:\\Users\\User3\\workspace\\EAd-Session-4\\src\\com\\Images\\signup.jpg' height = '30%'/><br>");
			}
			out.println("<input type = 'file' name = 'file' size = '20' /><br /><input type = 'submit' value = 'Upload File' /></form></td></tr>");
			out.println("<tr><td>" + user.getFirstName() + "</td></tr>");
			out.print("</table></td></tr></table></body></html>");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}
}
