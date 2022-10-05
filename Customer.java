//Name: Semih
//Surname: Bağ


import java.util.*;

public class Customer extends Person {
	private ArrayList<Product> products;
	
	public Customer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,String hasDriverLicence, ArrayList<Product> products) throws Exception{
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		setProducts(products);
	}
	
	public Customer(Person person, ArrayList<Product> products) throws Exception{
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicence());
		setProducts(products);
	}

	public String toString() {
		//Customer [id: 178 products=[Product [productName=Product2, transactionDate=1/2/2019, price=1500.0], Product [productName=Product3, transactionDate=1/11/2018, price=15000.0]]]
		String str = "Customer [id: "+getId()+" products=[";
		
		for (int i = 0 ; i < this.products.size() ; i++) {
			if(i == (this.products.size() - 1)) {
				str += products.get(i).toString();
			}
			else {
				str += products.get(i).toString();
				str += ", ";
			}
		}
		str += "]]";
		return str;
	}
	
	
	
	public ArrayList<Product> getProducts() throws Exception {
			return products;		
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
