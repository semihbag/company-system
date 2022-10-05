//Name: Semih
//Surname: Bağ


import java.util.*;

public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private java.util.Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicence;
	
	
	public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String marialStatus, String hasDriverLicence) throws Exception{
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setBirthDate(birthDate);
		setGender(gender);
		setMaritalStatus(marialStatus);
		setHasDriverLicence(hasDriverLicence);		
	}
	
	public String toString() {
		return ("Person [id="+getId()+", firstName="+getFirstName()+", lastName="+getLastName()+", gender="+getGender()+", birthDate="+getBirthDate().get(5)+"/"+getBirthDate().get(2)+"/"+getBirthDate().get(1)+", maritalStatus="+getMaritalStatus()+", hasDriverLicence="+getHasDriverLicence()+"]");
	}
	
	public String shortToString() {
		return ("Person Info [id="+getId()+", firstName="+getFirstName()+", lastName="+getLastName()+", gender="+getGender()+"]");
	}
	
	// Getters and setters methods
	// Get and set method for id
	public int getId() {
		return id;
	}
	public void setId(int id) throws Exception {
		this.id = isValidInt(id);
	}


	// Get and set method for firstName
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws Exception{
		this.firstName = isValidString(firstName);
	}

	
	// Get and set method for lastName
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) throws Exception {
		this.lastName = isValidString(lastName);

	}


	// Get and set method for birthDate
	public java.util.Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(java.util.Calendar birthDate) {
		this.birthDate = birthDate;
	}

	
	// Get and set method for gender
		public String getGender() {
			if(gender == 1) {
				return "Woman";
			}
			else {
				return "Man";
			}			
		}
		public void setGender(String gender) throws Exception {
			gender = isValidString(gender);
			gender = gender.toLowerCase();
			gender = gender.substring(0, 1).toUpperCase() + gender.substring(1);
			if(gender.equals("Woman")) {
				this.gender = 1;
			}
			else if(gender.equals("Man")) {
				this.gender = 2;
			}
			else {
				throw new Exception("Please write gender properly");
			}
		}
		
		
		// Get and set method for marialStasus
		public String getMaritalStatus() {
			if(maritalStatus == 1) {
				return "Single";
			}
			else {
				return "Married";
			}			
		}
		public void setMaritalStatus(String status) throws Exception {
			status = isValidString(status);
			status = status.toLowerCase();
			status = status.substring(0, 1).toUpperCase() + status.substring(1);
			if(status.equals("Single")) {
				this.maritalStatus = 1;
			}
			else if(status.equals("Married")) {
				this.maritalStatus = 2;
			}
			else {
				throw new Exception("Please write maritial status properly");
			}
		}
	
		// Get and set method for hasDriverLicence
		public String getHasDriverLicence() {
			if(hasDriverLicence) {
				return "Yes";
			}
			else {
				return "No";
			}
		}
		public void setHasDriverLicence(String info) throws Exception {
			info = info.trim();
			info = info.toLowerCase();
			info = info.substring(0, 1).toUpperCase() + info.substring(1);
			if(info.equals("Yes")) {
				this.hasDriverLicence = true;
			}
			else if(info.equals("No")) {
				this.hasDriverLicence = false;
			}
			else {
				throw new Exception("Please write your answer properly");
			}
		}
		
		
		
		// Extra methods
		public String isValidString(String str) throws Exception {
			str = str.trim();
			if(str.length() == 0) {
				throw new Exception("Please write a String value");
			}

			if(str.length() < 3){
				throw new Exception("String value should be no less than 3 symbols");
			}
			return str;
		}
		
		
		public int isValidInt(int num) throws Exception{
			if(num <= 0) {
				throw new Exception("The input must be positive");
			}
			else {
				return num;
			}
		}
}
