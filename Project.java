	//Name: Semih
	//Surname: Bað
	//Student ID:150120070

import java.util.*;

public class Project {
	private String projectName;
	private java.util.Calendar startDate;
	private boolean state;	
	
	public Project(String pName, Calendar startDate, String state) throws Exception {
		setProjectName(pName);
		setStartDate(startDate);
		setState(state);
	}
	
	public void close() {
		if(this.state) {
			this.state = false;
		}
	}
	
	public String toString() {
		//Project [projectName=FaceRecognition, startDate=1/7/2018, state=true]
		String str;
		str = (state)? "true":"false";
		return ("Project [projectName="+getProjectName()+", startDate="+getStartDate().get(5)+"/"+getStartDate().get(2)+"/"+getStartDate().get(1)+", state="+str+"]");
	}
	
	// Getters and setters methods
	// Get and set method for state
	public void setState(String state) throws Exception {
		state = state.trim();
		if(state.length() == 0) {
			throw new Exception("Please write a String value");
		}
		if(state.length() < 3){
			throw new Exception("String value should be no less than 3 symbols");
		}
		state = state.toLowerCase();
		state = state.substring(0, 1).toUpperCase() + state.substring(1);
		
		if(state.equals("Open")) {
			this.state  = true;
		}
		else if(state.equals("Close")) {
			this.state  = false;
		}
		else {
			throw new Exception("Please write your answer properly");
		}
	}
	
	public String getState() {
		if(this.state) {
			return "Open";
		}
		else {
			return "Close";
		}
	}

	
	
	// Get and set method for project name
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) throws Exception {
		projectName = projectName.trim();
		if(projectName.length() == 0) {
			throw new Exception("Please write a String value");
		}
		if(projectName.length() < 3){
			throw new Exception("String value should be no less than 3 symbols");
		}
		this.projectName = projectName;
	}

	
	// Get and set method for start date
	public java.util.Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(java.util.Calendar startDate) {
		this.startDate = startDate;
	}

	
	
	
	
	
	
	
}
