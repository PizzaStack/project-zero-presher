package com.cliff.manager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.cliff.manager.getEmployees.GetManagersNameDAO;
import com.cliff.manager.getEmployees.GetManagersNameImpl;
import com.cliff.manager.getEmployees.ManagersInfo;

/**
 * Servlet implementation class GetManagersNameServlet
 */
public class GetManagersNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String getSession = (String) session.getAttribute("username");
		
//		GetManagersNameDAO eid = new GetManagersNameImpl();
//
//		ManagersInfo mi = eid.getManagerInfo(getSession);
		
		JSONObject manager = new JSONObject();
		manager.put("name", getSession);
		response.getWriter().print(manager);
	}

}
