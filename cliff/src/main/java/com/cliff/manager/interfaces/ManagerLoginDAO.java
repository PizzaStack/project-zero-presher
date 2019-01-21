package com.cliff.manager.interfaces;

import com.cliff.manager.getEmployees.Managers;

public interface ManagerLoginDAO {

	public Managers getManagers(String userName,String password);

	}
