package com.sarmisegetusa.pojo;

/**
 * 
 * This class stores an employee's first name, last name and their role
 *
 */
public class Record {

	/** First Name of Employee */
	private String firstName;
	
	/** Last Name of Employee */
	private String lastName;
	
	/** Role of Employee */
	private String role;

	/** Getters and Setters */
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
