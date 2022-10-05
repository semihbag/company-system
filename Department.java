	//Name: Semih
	//Surname: Bað
	//Student ID:150120070

public class Department {
	private int departmentId;
	private String departmentName;
	
	public Department(int departmentId, String departmentName) throws Exception {
		setDepartmentId(departmentId);
		setDepartmentName(departmentName);
	}
	
	public String toString() {
		String str = "************************************************\n";
		str += "Department [departmentId="+this.departmentId+", departmentName="+this.departmentName+"]\t";
		return str;
	}
	
	
	
	
	// Getters and setters methods
	// Get and set method for deparmentId
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) throws Exception {
		if(departmentId <= 0) {
			throw new Exception("the input must be positive");
		}
		else {
			this.departmentId = departmentId;
		}
	}
	
	// Get and set method for deparmentName
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) throws Exception {
		departmentName = departmentName.trim();
		if(departmentName.length() == 0) {
			throw new Exception("Please write a String value");
		}
		if(departmentName.length() < 3){
			throw new Exception("String value should be no less than 3 symbols");
		}
		this.departmentName = departmentName;
	}
}
