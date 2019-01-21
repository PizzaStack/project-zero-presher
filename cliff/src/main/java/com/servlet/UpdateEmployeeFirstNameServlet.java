package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.cliff.manager.getEmployees.GetEmployeeDAOImpl;

import employeeInfo.UpdateEmployeeFirstName;

/**
 * Servlet implementation class UpdateEmployeeFirstNameServlet
 */
public class UpdateEmployeeFirstNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String getSession = (String) session.getAttribute("username");
		System.out.println(getSession + "name");
		
		String fName = request.getParameter("First_Name");
		System.out.println(fName + "name" + "name");
		
		if(fName == null) {
			response.getWriter().print("Your Name was not updated");
		}else {
		
		new UpdateEmployeeFirstName().updateEmployeefname(getSession, fName);
		JSONObject gdi = new GetEmployeeDAOImpl().employee(fName);
		System.out.println(gdi);
		response.getWriter().print(gdi);
		}
	}

}
