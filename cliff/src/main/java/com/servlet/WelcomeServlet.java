package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet WelcomeServlet</title>");
		out.println("</head>");
		out.println("<body>");
		System.out.print(session.getAttribute("fname"));
		session.getAttribute("fname");
		
//		request.getAttribute("lname");
//		request.getAttribute("email");
//		request.getAttribute("ri");
		request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		out.println("</body>");
		out.println("</html>");
//	request.getRequestDispatcher("Welcome.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
