package com.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.UserFacade;

/**
 * Servlet Filter implementation class AuthenticateFilter
 */
@WebFilter("/AuthenticateFilter")
public class AuthenticateFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticateFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email = request.getParameter("logEmail");
		String password = request.getParameter("logPassword");
		UserFacade userFacade = UserFacade.getInstance();
		try {
			if (userFacade.authenticateUser(email, password)) {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				HttpSession session = httpRequest.getSession();
				session.setAttribute("email", email);
				chain.doFilter(request, response);
			} else {
				HttpServletResponse httpsResponse = (HttpServletResponse) response;
				httpsResponse.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
