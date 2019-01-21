package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.Employee;
import login.EmployeeDAOImpl;
import login.EmployeeLoginDAO;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeLoginDAO eld = new EmployeeDAOImpl();
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		Employee em = eld.getEmployee(userName, password);
		
		if(em != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", em.getUserName());
		
			request.getRequestDispatcher("./GetUserInfoServlet").forward(request, response);
		}else {
			request.getRequestDispatcher("Logout").forward(request, response);
		}
		 
	}
}
