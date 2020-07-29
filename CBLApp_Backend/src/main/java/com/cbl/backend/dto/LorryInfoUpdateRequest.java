package com.cbl.backend.dto;

public class LorryInfoUpdateRequest {
	
	private int lorryID;
	private String firstName;
	private String lastName;
	private int phonenumber;
	private boolean accountStatus;
	
	
	
	public int getLorryID() {
		return lorryID;
	}
	public void setLorryID(int lorryID) {
		this.lorryID = lorryID;
	}
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
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public boolean isAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	@Override
	public String toString() {
		return "LorryRequest [lorryID=" + lorryID + " ,firstName=" + firstName + ", lastName=" + lastName
				+ ", phonenumber=" + phonenumber + "]";
	}
	
}
