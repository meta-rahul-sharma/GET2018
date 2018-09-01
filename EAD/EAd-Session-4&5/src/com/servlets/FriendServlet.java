package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.databaseconnection.Dao;
import com.model.User;
import com.model.UserFriend;
import com.pojo.Employee;

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
		
		UserDao dao = UserDao.getInstance();
		
		User user = (User) request.getAttribute("user");
		UserFriend userFriends = new UserFriend(user);

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Show All Employee</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Show All Employee</h1>");
		out.println("<table align='center' cellspacing='30px'>");
		out.println("<th>");
		out.println("<td>First Name</td>");
		out.println("<td>Last Name</td>");
		out.println("<td>Email</td>");
		out.println("<td>Age</td>");
		out.println("</th>");
		int rowCount = 1;
		for (User user : userFriends) {
			out.println("<tr>");
			out.println("<td>" + rowCount + "</td>");
			out.println("<td>" + employee.getFirstName() + "</td>");
			out.println("<td>" + employee.getLastName() + "</td>");
			out.println("<td>" + employee.getEmail() + "</td>");
			out.println("<td>" + employee.getAge() + "</td>");
			out.println("<td><a href='UpdateEmployee?email=" + employee.getEmail()
					+ "&firstName=" + employee.getFirstName() + "&lastName="
					+ employee.getLastName() + "&age=" + employee.getAge()
					+ "'>Edit</a></td></tr>");
			rowCount++;
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
