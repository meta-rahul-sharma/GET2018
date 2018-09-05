package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.facade.UserFacade;
import com.model.User;
import com.model.UserFriend;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserFacade facade = UserFacade.getInstance();
		String email = (String) request.getParameter("email");
		User user = null;
		try {
			user = facade.getUser(email);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		UserFriend userFriends = null;
		try {
			userFriends = facade.getUserFriends(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Friends</title>");
		out.print("<link href = 'Design.css' rel = 'stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Friends</h1>");
		out.println("<table align='center' cellspacing='30px'>");
		out.println("<th>");
		out.println("<td>First Name</td>");
		out.println("<td>Last Name</td>");
		out.println("<td>Email</td>");
		out.println("<td>Age</td>");
		out.println("</th>");
		int rowCount = 1;
		for (User friends : userFriends.getFriends()) {
			if(friends.getId() != user.getId()) {
				out.println("<tr>");
				out.println("<td>" + rowCount + "</td>");
				out.println("<td>" + friends.getFirstName() + "</td>");
				out.println("<td>" + friends.getLastName() + "</td>");
				out.println("<td>" + friends.getEmail() + "</td>");
				out.println("<td><a href='FriendInfo?friendEmail=" + friends.getEmail() +"'>View Profile</a></td></tr>");
				rowCount++;
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
