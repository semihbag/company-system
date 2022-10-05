//Name: Semih
//Surname: Bağ


import java.util.*;

public class Developer extends RegularEmployee{
	private ArrayList<Project> projects;
	public static int numberOfDevelopers;
	
	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore, ArrayList<Project> p) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		setProjects(p);
	}

	public Developer(RegularEmployee re, ArrayList<Project> p) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		setProjects(p);
	} 
	
	
	public boolean addProject(Project s) {
		if (!(this.projects.contains(s))) {
			return projects.add(s);
		}
		else {
			return false;
		}
	}
	
	public boolean removeProject(Project s) {
		if (this.projects.contains(s)) {
			return projects.remove(s);
		}
		else {
			return false;
		}
	}
	
	
	public String toString() {
		String str = "Developer\n";
		str += "				"+shortToString()+"\n";
		str += "				"+"Employee Info [salary="+getSalary()+", hireDate="+getHireDate().get(5)+"/"+getHireDate().get(2)+"/"+getHireDate().get(1)+"]"+"\n";
		str += "				Regular Employee Info [performanceScore="+getPerformanceScore()+", bonus="+getBonus()+"]"+"\n\t";
		str += "			";
		for (int i = 0 ; i < this.projects.size() ; i++) {
			if(i == (this.projects.size() - 1)) {
				str += ""+projects.get(i).toString();
			}
			else {
				str += ""+projects.get(i).toString();
				str += ", ";
			}
		}
		str += "]]";
		return str;
	}
	
	
	
	// Getters and setters methods
	// Get and set method for projects
	public ArrayList<Project> getProjects() {
		return projects;
	}
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

}
