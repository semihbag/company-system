//Name: Semih
//Surname: Bağ


import java.util.Calendar;

public class RegularEmployee extends Employee {
	private double performanceScore;
	private double bonus;
	
	public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore) throws Exception{
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		setPerformanceScore(performanceScore);
	}
	
	public RegularEmployee(Employee employee, double perfScore) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setPerformanceScore(perfScore);
	}
	
	public String toString() {
		return ("RegularEmployee Info [performanceScore="+getPerformanceScore()+", bonus="+getBonus()+"]");
	}
	
	// Getters and setters method
	// Get and set method for performance score
	public double getPerformanceScore() {
		return performanceScore;
	}
	public void setPerformanceScore(double performanceScore) {
		this.performanceScore = performanceScore;
	}

	
	// Get and set method for bonus
	public double getBonus() {
		
		return (((int)(bonus*100))/100.0);
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
