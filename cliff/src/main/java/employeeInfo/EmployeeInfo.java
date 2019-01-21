package employeeInfo;

public class EmployeeInfo {
	
	private String lname;
	private String fname;
	private String email;
	private String reimbursementStatus;
	
	public String getLname() {
		return lname;
	}
	public String setLname(String lname) {
		return this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public String setFname(String fname) {
		return this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public String setEmail(String email) {
		return this.email = email;
	}
	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	public String setReimbursementStatus(String reimbursementStatus) {
		return this.reimbursementStatus = reimbursementStatus;
	}
	public EmployeeInfo(String lname, String fname, String email, String reimbursementStatus) {
		super();
		this.lname = lname;
		this.fname = fname;
		this.email = email;
		this.reimbursementStatus = reimbursementStatus;
	}
	@Override
	public String toString() {
		return "EmployeeInfo [lname=" + lname + ", fname=" + fname + ", email=" + email + ", reimbursementStatus="
				+ reimbursementStatus + "]";
	}
	
	
	

}
