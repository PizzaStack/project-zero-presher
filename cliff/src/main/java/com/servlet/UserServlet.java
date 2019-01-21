package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import employeeInfo.EmployeeInfo;
import employeeInfo.EmployeeInfoDAO;
import employeeInfo.GetEmployeeInfoFromDatabaseImpl;

/**
 * Servlet implementation class TestServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String getSession = (String) session.getAttribute("username");

		JSONObject eid = new GetEmployeeInfoFromDatabaseImpl().getEmployeeInfo(getSession);

		//EmployeeInfo ei = eid.getEmployeeInfo(getSession);
		
//		JSONObject people = new JSONObject();
//		people.put("fname", ei.getFname());
//		people.put("lname", ei.getLname());
//		people.put("email", ei.getEmail());
//		people.put("ri", ei.getReimbursementStatus());
			
		
		response.getWriter().print(eid);
		
		//request.getRequestDispatcher("./templates/welcome.html").forward(request, response);
	}
	
	
}
