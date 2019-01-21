package com.cliff.manager.getEmployees;

public class GetEmployeeNameOnStatus {
	
	private String employeeName;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public GetEmployeeNameOnStatus(String employeeName) {
		super();
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "GetEmployeeNameOnStatus [employeeName=" + employeeName + "]";
	}
	
	

}
