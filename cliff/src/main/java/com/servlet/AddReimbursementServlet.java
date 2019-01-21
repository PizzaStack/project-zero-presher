package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cliffco.connections.MakeConnection;

import employeeInfo.AddReimbursementImpl;

/**
 * Servlet implementation class AddReimbursementServlet
 */
public class AddReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		String type = request.getParameter("request");
		
		new AddReimbursementImpl().addReimbursement(username, type);
		response.getWriter().print("Your Request Has BeenSubmitted");
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

}
