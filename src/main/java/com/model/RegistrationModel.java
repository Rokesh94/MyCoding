package com.model;

public class RegistrationModel {
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private String Address;
	private int Contact;
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getContact() {
		return Contact;
	}
	public void setContact(int contact) {
		Contact = contact;
	}
	
	@Override
	public String toString() {
		return  FirstName+ " " +LastName+ " "+UserName+" "+Address+" "+Contact ;
		
	}
}
