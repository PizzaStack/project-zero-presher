package com.cliff.manager.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.cliff.manager.getEmployees.GetEmployeeDAOImpl;


/**
 * Servlet implementation class GetEmployeeByNameServlet
 */
public class GetEmployeeByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selectedEmployee = request.getParameter("employee");
		HttpSession session = request.getSession();
		
		JSONObject gdi = new GetEmployeeDAOImpl().employee(selectedEmployee);
		
				String htmlResposne = "<html>";
        htmlResposne += "<h2>Employee's name is: " + gdi.getString("First_Name") + "<br/>";      
        htmlResposne += "Employees's email is: " + gdi.getString("Email") + "</br>"; 
        htmlResposne += "Employees Reimbursement Satatus is: " + gdi.getString("RI")+ "</h2>";
        htmlResposne += "</html>";
        
		request.getRequestDispatcher("./managers/welcomeManagers.html").forward(request, response);
	}

}
