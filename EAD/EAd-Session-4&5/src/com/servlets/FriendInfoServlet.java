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
 * Servlet implementation class FriendInfoServlet
 */
@WebServlet("/FriendInfoServlet")
public class FriendInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String friendEmail = (String) request.getParameter("friendEmail");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		UserFacade facade = UserFacade.getInstance();
		User friend = null;
		try {
			friend = facade.getUser(friendEmail);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(friendEmail);
		System.out.println(friend.getFirstName());
		PrintWriter out = response.getWriter();
		String filePath = getServletContext().getInitParameter("profileImage");
		File profileImage = new File(filePath + "\\" + friendEmail + ".jpg");
		out.print(
				"<img name = 'imageOfUser'src=''><form action='FriendServlet' method='get'><input type='hidden' name='email' value='"
						+ friendEmail
						+ "'/><input type='submit' value='Friends'></form><a href='LogoutServlet'>Logout</a><br/><br/> ");
		if (profileImage.exists()) {
			out.print("<img src='" + profileImage + "' height = '30%'/><br>");
		} else {
			out.print("<img src='" + filePath + "\\default.png' height = '30%'/><br>");
		}
		out.print("<form action='ProfileServlet' method='post'>" + "<h1 align=''center>Profile</h1><br />"
				+ "<table cellpadding='5'><tr>" + "<th align='left'>First Name :</th>"
				+ "<td><input type='text' name = 'firstName' value= '" + friend.getFirstName()
				+ "' readonly/></td></tr>" + "<th align='left'>Last Name :</th>"
				+ "<td><input type='text' name = 'lastName' value= '" + friend.getLastName()
				+ "' readonly/></td></tr>" + "<tr><th align='left'>Age :</th>"
				+ "<td><input type='' name = 'dateOfBirth' value='" + friend.getDob()
				+ "' readonly/></td></tr>" + "<tr><th align='left'>Contact No. :</th>"
				+ "<td><input type='number' name='contact' value='" + friend.getContact()
				+ "' readonly/></td></tr>" + "<tr><th align='left'>Email :</th>"
				+ "<td><input type='email' name='email' value='" + friend.getEmail() + "' readonly/></td></tr>"
				+ "<tr><th align='left'>Company/Institute :</th>"
				+ "<td><input type='text' name = 'organization' value='" + friend.getOrganization()
				+ "' readonly /></td>" + "</tr><tr><td><input type='submit' value='Back'></td></tr></table>"
				+ "<input type='hidden' name='hiddenEmail' value='" + email + "'/></form>");
	}
}
