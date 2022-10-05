//Name: Semih
//Surname: Bağ


import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		
		try {
			Scanner input = new Scanner(new File("input.txt"));
			
			ArrayList<Object> objects = new ArrayList<>();
				
			int currentLine = 0;

			while(input.hasNextLine()) {
				currentLine++;
				String line = input.nextLine();
				String[] words = line.split(" ");
				
				switch (words[0]) {
					case "Department":
						Object department = new Department(Integer.parseInt(words[1]), words[2]);
						objects.add(department);
						break;
						
					case "Project":						
						Object project = new Project(words[1], findDate(words[2]), words[3]);
						objects.add(project);
						break;
						
					case "Product":
						Object product = new Product(words[1], findDate(words[2]), Double.parseDouble(words[3]));
						objects.add(product);
						break;
						
					case "Person":
						Object person = new Person(Integer.parseInt(words[3]), words[1], words[2], words[4], findDate(words[5]), words[6], words[7]);						
						objects.add(person);
						break;
						
					case "Customer":	
						Object customer  = new Customer(findPersonWithId(words[1], objects), findProductsWithName(words, objects));
						objects.remove(findPersonWithId(words[1], objects));
						objects.add(customer);
						break;
						
					case "Employee":
						Object employee = new Employee(findPersonWithId(words[1], objects), Integer.parseInt(words[2]), findDate(words[3]), findDepartmentWithName(words[4], objects));
						objects.remove(findPersonWithId(words[1], objects));
						objects.add(employee);
						break;
						
					case "Manager":
						Object manager = new Manager(findEmployeeWithId(words[1], objects), Double.parseDouble(words[2]));
						objects.remove(findEmployeeWithId(words[1], objects));
						objects.add(manager);
						break;
						
					case "RegularEmployee":
						Object regularEmployee = new RegularEmployee(findEmployeeWithId(words[1], objects), Double.parseDouble(words[2]));
						objects.remove(findEmployeeWithId(words[1], objects));
						objects.add(regularEmployee);
						break;
						
					case "SalesEmployee":	
						Object salesEmployee = new SalesEmployee(findRegularEmployeeWithId(words[1], objects), findProductsWithName(words, objects));
						objects.remove(findRegularEmployeeWithId(words[1], objects));
						objects.add(salesEmployee);						
						break;
						
					case "Developer":						
						Object developer = new Developer(findRegularEmployeeWithId(words[1], objects), findProjectsWithName(words, objects));
						objects.remove(findRegularEmployeeWithId(words[1], objects));
						objects.add(developer);
						break;
						
					default:
						throw new Exception("Line number " + currentLine + " could not be read!");
				}	
			}
			input.close();
			
			for (int i = 0 ; i < objects.size() ; i++) {
				if (objects.get(i) instanceof Manager) {
					Manager man = (Manager)(objects.get(i));
					for (int j = 0 ; j < objects.size() ; j++) {
						if (((objects.get(j) instanceof RegularEmployee)&&(!(objects.get(j) instanceof SalesEmployee))&&(!(objects.get(j) instanceof Developer))) || (objects.get(j) instanceof SalesEmployee) || (objects.get(j) instanceof Developer)) {
						RegularEmployee reg = (RegularEmployee)(objects.get(j));
							if (reg.getDepartment().getDepartmentName().equals(man.getDepartment().getDepartmentName())) {
								if(man.getRegularEmployees().size() == 0) {
									
								}
								
								for (int k = 0 ; k < man.getRegularEmployees().size() ; k++) {
									
								}
								
								man.addEmployee(reg);
							}
						}
					}
				}
			}
			
			for (int i = 0 ; i < objects.size() ; i++) {
				if (objects.get(i) instanceof Manager) {
					Manager man = (Manager)(objects.get(i));
					man.distributeBonusBudget();
				}
			}	
			
			for (int i = 0 ; i < objects.size() ; i++) {
				if(objects.get(i) instanceof Manager) {
					Manager man = (Manager)(objects.get(i));
					man.setSalary(man.raiseSalary(0.2));;
				}
			}		
			
			for (int i = 0 ; i < objects.size() ; i++) {
				if((objects.get(i) instanceof RegularEmployee) && (!(objects.get(i) instanceof SalesEmployee)) && (!(objects.get(i) instanceof Developer))){
					RegularEmployee reg = (RegularEmployee)(objects.get(i));
					reg.setSalary(reg.raiseSalary(0.3));
				}
			}
		
			for (int i = 0 ; i < objects.size() ; i++) {
				if(objects.get(i) instanceof Developer) {
					Developer dev = (Developer)(objects.get(i));
					dev.setSalary(dev.raiseSalary(0.23));
				}
			}
			
			for (int i = 0 ; i < objects.size() ; i++) {
				if(objects.get(i) instanceof SalesEmployee) {
					SalesEmployee sal = (SalesEmployee)(objects.get(i));
					sal.setSalary(sal.raiseSalary(0.18));
				}
					
			}
			findBestSalesEmployee(objects).raiseSalary(1000);
			
			File outputFile = new File("output.txt");
			PrintWriter output = new PrintWriter(outputFile);
			
			for(int i = 0 ; i < objects.size() ; i++) {
				if(objects.get(i) instanceof Department) {
  				Department dep = (Department)(objects.get(i));
					for(int j = 0 ; j < objects.size() ;j++) {
						if(objects.get(j) instanceof Manager) {
							Manager man = (Manager)(objects.get(j));
							if(dep.getDepartmentName().equals(man.getDepartment().getDepartmentName())) {
								output.println(dep.toString());
								System.out.println(dep.toString());
								output.println(man.toString());
								System.out.println(man.toString());
							}
						}
					}
				}
					
			}
			System.out.println("**********************CUSTOMERS************************");
			output.println("**********************CUSTOMERS************************");
			
			for(int i = 0 ; i< objects.size() ; i++) {
				if(objects.get(i) instanceof Customer) {
					System.out.println(objects.get(i).toString());
					output.println(objects.get(i).toString());
				}
			}
			
			output.println();
			System.out.println("**********************PEOPLE************************");
			output.println("**********************PEOPLE************************");
			
			for(int i = 0 ; i < objects.size() ; i++) {
				if((objects.get(i) instanceof Person) && (!(objects.get(i) instanceof Employee)) && (!(objects.get(i) instanceof Manager)) && (!(objects.get(i) instanceof RegularEmployee)) && (!(objects.get(i) instanceof SalesEmployee)) && (!(objects.get(i) instanceof Department)) && (!(objects.get(i) instanceof Customer))) {
					System.out.println(objects.get(i).toString());
					output.println(objects.get(i).toString());
					
				}
			} 
			output.println();

			output.close();	
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
		}		
	}

	
	
	
	public static Person findPersonWithId(String id, ArrayList<Object> objects) throws Exception {		
		for (int i = 0 ; i < objects.size() ; i++) {
			if(objects.get(i) instanceof Person) {
				Person per = (Person)(objects.get(i));
				if(per.getId() == Integer.parseInt(id)) {
					return per;
				}
				
			}
		}
		throw new Exception("The person with given id could not found!");
	}
	
	
	public static Employee findEmployeeWithId(String id, ArrayList<Object> objects) throws Exception {		
		for(int i = 0 ; i < objects.size() ; i++) {
			if(objects.get(i) instanceof Employee) {
				Employee emp = (Employee)(objects.get(i));
				if (emp.getId() == Integer.parseInt(id)) {
					return emp;
				}
			}
		}
		throw new Exception("The employee with given id could not found!");
	}
	
	
	public static RegularEmployee findRegularEmployeeWithId(String id, ArrayList<Object> objects) throws Exception {
		for (int i = 0 ; i < objects.size() ; i++) {
			if (objects.get(i) instanceof RegularEmployee) {
				RegularEmployee reg = (RegularEmployee)(objects.get(i));
				if(reg.getId() ==  Integer.parseInt(id)) {
					return reg;
				}
			}
		}
		throw new Exception("The regular employee with given id could not found!");
	}
	
	
	public static Calendar findDate(String str) {
		String[] dmy = str.split("/");
		Calendar date = Calendar.getInstance();
		date.set(Integer.parseInt(dmy[2]), Integer.parseInt(dmy[1]), Integer.parseInt(dmy[0]));
		return date;
	}
	
	
	public static ArrayList<Product> findProductsWithName(String[] words, ArrayList<Object> objects) throws Exception {
		ArrayList<Product> products = new ArrayList<>();
		
		for(int i = 2 ; i < words.length ; i++) {
			for (int j = 0 ; j < objects.size() ; j++) {
				if (objects.get(j) instanceof Product) {
					Product pro = (Product)(objects.get(j));
					if (words[i].equals(pro.getProductName())) {
						products.add(pro);
					}
				}
			}
		}
		if(products.size() == 0) {
			throw new Exception("The product with given name could not found!");
		}
		else {
			return products;
		}
	}
	
	
	
	public static ArrayList<Project> findProjectsWithName (String[] words, ArrayList<Object> objects) throws Exception {
		ArrayList<Project> projects = new ArrayList<>();
		
		for (int i = 2 ; i< words.length ; i++) {
			for(int j = 0 ; j < objects.size() ; j++) {
				if (objects.get(j) instanceof Project) {
					Project pro = (Project)(objects.get(j));
					if(words[i].equals(pro.getProjectName())) {
						projects.add(pro);
					}
						
				}
			}
		}
		if(projects.size() == 0) {
			throw new Exception("The project with given name could not found!");
		}
		else {
			return projects;
		}
	}
	
	
	public static Department findDepartmentWithName(String name, ArrayList<Object> objects) throws Exception {
		for (int i = 0 ; i < objects.size() ; i++) {
			if(objects.get(i) instanceof Department) {
				Department dep = (Department)(objects.get(i));
				if(name.equals(dep.getDepartmentName())) {
					return dep;
				}
			}
		}
		throw new Exception("The department with given name could not found!");
	}
	
	
	public static SalesEmployee findBestSalesEmployee(ArrayList<Object> objects) throws Exception {
		int index = -1;
		double MaxTotal = 0;
		for (int i = 0 ; i < objects.size() ; i++) {
			if (objects.get(i) instanceof SalesEmployee) {
				SalesEmployee sal = (SalesEmployee)(objects.get(i));
				double currentTotal = sal.totalPriceOfSales();
				if(currentTotal >= MaxTotal) {
					MaxTotal = currentTotal;
					index = i;
				}
			}
		}
		if(index == -1) {
			throw new Exception("There is no sales employees");
		}
		else {
			SalesEmployee salesEmployee = (SalesEmployee)(objects.get(index));
			return salesEmployee;
		}
	}
}
