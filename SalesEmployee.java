	//Name: Semih
	//Surname: Bað
	//Student ID:150120070

import java.util.*;

public class SalesEmployee extends RegularEmployee{
	public ArrayList<Product> sales;
	public static int numberOfSalesEmployees;
	
	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore, ArrayList<Product> s) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		setSales(s);
		numberOfSalesEmployees++;
	}
	
	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		setSales(s);
		numberOfSalesEmployees++;
	}
	
	
	public boolean addSale(Product s) throws Exception {
			return sales.add(s);
	}
	
	public boolean removeSale(Product s) {
		if (this.sales.contains(s)) {
			return sales.remove(s);
		}
		else {
			return false;
		}
	}
	

	public double totalPriceOfSales() {
		double totalPrice = 0;
		for(int i = 0 ; i < this.sales.size() ; i++) {
			totalPrice += sales.get(i).getPrice();
		}
		return totalPrice;
	}
	
	public String toString() {
		String str = "SalesEmployee\n";
		str += "\t			"+shortToString()+"\n";
		str += "\t			"+"Employee Info [salary="+getSalary()+", hireDate="+getHireDate().get(5)+"/"+getHireDate().get(2)+"/"+getHireDate().get(1)+"]"+"\n";
		str += "\t			Regular Employee Info [performanceScore="+getPerformanceScore()+", bonus="+getBonus()+"]"+"\n\t";
		str += "			";
		for (int i = 0 ; i < this.sales.size() ; i++) {
			if(i == (this.sales.size() - 1)) {
				str +=""+sales.get(i).toString();
			}
			else {
				str +=""+ sales.get(i).toString();
				str += ", ";
			}
		}
		str += "]]";
		return str;
	}
	
	
	
	
	// Getters and setters methods
	// Get and set method for sales
	public ArrayList<Product> getSales() {
		return sales;
	}
	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}
	
	
	
	
	
	
}
