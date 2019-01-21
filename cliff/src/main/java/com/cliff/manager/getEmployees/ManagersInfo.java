package com.cliff.manager.getEmployees;

public class ManagersInfo {

	private String name;
	
	public ManagersInfo(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ManagersInfo [name=" + name + "]";
	}
}

