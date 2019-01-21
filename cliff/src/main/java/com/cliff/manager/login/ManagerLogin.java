package com.cliff.manager.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.cliff.manager.getEmployees.Managers;
import com.cliff.manager.implemtations.ManagerDAOImpl;
import com.cliff.manager.interfaces.ManagerLoginDAO;

import login.Employee;
import login.EmployeeDAOImpl;
import login.EmployeeLoginDAO;

/**
 * Servlet implementation class ManagerLogin
 */
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ManagerLoginDAO eld = new ManagerDAOImpl();

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		Managers em = eld.getManagers(userName, password);
		
		

		if (em != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", em.getUserName());
			System.out.println(userName + "logged in");
			request.getRequestDispatcher("./GetManagerInfo").forward(request, response);
		} else {
			System.out.println("logout");
			request.getRequestDispatcher("Logout").forward(request, response);
		}
	}

}
