//Name: Semih
//Surname: Bağ


import java.util.*;

public class Employee extends Person {
	private double salary;
	private java.util.Calendar hireDate;
	private Department department;
	public static int numberOfEmployees;
	
	
	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		setSalary(salary);
		setHireDate(hireDate);
		setDepartment(department);
		numberOfEmployees++;
	}
	
	public Employee(Person person, double salary, Calendar hireDate, Department department) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicence());
		setSalary(salary);
		setHireDate(hireDate);
		setDepartment(department);
		numberOfEmployees++;
	}

	public double raiseSalary(double percent) throws Exception{
		if (percent < 0 || percent > 1) {
			throw new Exception("Percentile must be between or equal 0 and 1");
		}
		else {
			this.salary = this.salary * (1 + percent);
			return this.salary;
		}
	}

	public double raiseSalary(int amount) throws Exception {
		if (amount <= 0) {
			throw new Exception("The input must be positive");
		}
		else {
			this.salary += amount;
			return this.salary;
		}
	}

	
	public String toString() {
		return ("Employee Info [salary="+this.salary+", hireDate="+getHireDate().get(5)+"/"+getHireDate().get(2)+"/"+getHireDate().get(1)+"]");
	}
	

	
	// Getters and setters methods
	// Get and set method for salary
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	// Get and set method for department
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	// Get and set method for hire date
	public java.util.Calendar getHireDate() {
		return hireDate;
	}
	public void setHireDate(java.util.Calendar hireDate) {
		this.hireDate = hireDate;
	}

	
	// Get method for hire number of employee
	public static int getNumberOfEmployees() {
		return numberOfEmployees;
	}
}
