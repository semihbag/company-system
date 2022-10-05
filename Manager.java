	//Name: Semih
	//Surname: Bað
	//Student ID:150120070

import java.util.*;

public class Manager extends Employee {
	private ArrayList<RegularEmployee> regularEmployees;
	private double bonusBudget;
	
	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,double bonusBudget) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		setBonusBudget(bonusBudget);
		regularEmployees = new ArrayList<>();
	}
	
	public Manager(Employee employee, double bonusBudget) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setBonusBudget(bonusBudget);
		regularEmployees = new ArrayList<>();
	}
	
	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);
	}
	
	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);
	}

	
	public void distributeBonusBudget() {
		double unit;
		double total = 0;
		
		for (int i = 0 ; i < regularEmployees.size() ; i++) {
			total += (regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore());
		}
		unit = bonusBudget / total;
		
		for (int i = 0 ; i < regularEmployees.size() ; i++) {
			
			RegularEmployee r = regularEmployees.get(i);
			r.setBonus(unit * r.getSalary() * r.getPerformanceScore());
		}
	}
	
	public String toString() {		
		String str = "	Manager [id:"+getId()+", "+getFirstName()+" "+getLastName()+"\n\t	# of Employees: "+this.regularEmployees.size()+"]\n\t";
		int numberOfRegularEmployee = 1;
		for(int i = 0 ; i < this.regularEmployees.size() ; i++) {
			if(regularEmployees.get(i) instanceof Developer) {
				str += "\t\t"+numberOfRegularEmployee+". ";
				str += regularEmployees.get(i).toString();
				str += "\n\t";
				numberOfRegularEmployee++;

			}
		}
	
		for(int i = 0 ; i < this.regularEmployees.size() ; i++) {
			if(regularEmployees.get(i) instanceof SalesEmployee) {
				str += "\t\t"+numberOfRegularEmployee+". ";
				str += regularEmployees.get(i).toString();
				str += "\n\t";
				numberOfRegularEmployee++;

			}
		}
		
		for(int i = 0 ; i < this.regularEmployees.size() ; i++) {
			if((regularEmployees.get(i) instanceof RegularEmployee)&&(!(regularEmployees.get(i) instanceof SalesEmployee))&&(!(regularEmployees.get(i) instanceof Developer))){
				str += "\t"+numberOfRegularEmployee+". RegularEmployee\n";
				str += "				"+regularEmployees.get(i).shortToString()+"\n";
				str += "				Employee Info [salary"+regularEmployees.get(i).getSalary()+", hireDate="+regularEmployees.get(i).getHireDate().get(5)+"/"+regularEmployees.get(i).getHireDate().get(2)+"/"+regularEmployees.get(i).getHireDate().get(1)+"]\n";
				str += "				"+regularEmployees.get(i).toString();
				str += "\n\t";
				numberOfRegularEmployee++;
			}
		}
		return str;
	
	
	}
	
	
	
	
	// Getters and setters method
	// Get and set method for regular employees
	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}
	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}

	
	// Get and set method for regular bonus budget
	public double getBonusBudget() {
		return bonusBudget;
	}
	public void setBonusBudget(double bonusBudget) {
		this.bonusBudget = bonusBudget;
	}
}
