package com.cliff.manager.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliff.manager.getEmployees.GetEmployeeDAOImpl;
import com.cliff.manager.getEmployees.UpdateStatusDAOImpl;

/**
 * Servlet implementation class ReimbursementStatusUpdateServlet
 */
public class ReimbursementStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String statusUpdate = request.getParameter("status").toUpperCase();
		String employeeName = request.getParameter("employeeFirstName");
		
		System.out.println(employeeName + statusUpdate);
		new UpdateStatusDAOImpl().status(statusUpdate, employeeName);
				
		//response.getWriter().print(new UpdateStatusDAOImpl().status(statusUpdate, employeeName));
		//request.getRequestDispatcher("SendReimbursementStatusEmailServlet").forward(request, response);
		request.getRequestDispatcher("./managers/welcomeManagers.html").forward(request, response);
	}

}
