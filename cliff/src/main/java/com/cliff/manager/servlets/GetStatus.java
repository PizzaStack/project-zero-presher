package com.cliff.manager.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cliff.manager.getEmployees.GetEmployeeNameOnStatus;
import com.cliff.manager.getEmployees.GetEmployeeNamesOnStatusDAO;
import com.cliffco.connections.MakeConnection;

/**
 * Servlet implementation class GetStatus
 */
public class GetStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status").toUpperCase();
	
		JSONArray esd = new GetEmployeeNamesOnStatusDAO().GetStatus(status);
		
		response.getWriter().print(esd);
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	}
