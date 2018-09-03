package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class SetProfileImageServlet
 */
@WebServlet("/SetProfileImageServlet")
public class SetProfileImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int maxFileSize = 200 * 1024;
	private int maxMemSize = 16 * 1024;
	private File file;   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = getServletContext().getInitParameter("profileImage");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		PrintWriter out = response.getWriter();
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(new ServletRequestContext(request));

			// Process the uploaded file items
			Iterator i = fileItems.iterator();
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					file = new File(filePath + "\\" + email + ".jpg");
					fi.write(file);
					out.println("Uploaded Filename: " + file + "<br>");
					out.println(
							"<form action='ProfileServlet' method='post'><input type='submit' value='Back'></form>");
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
