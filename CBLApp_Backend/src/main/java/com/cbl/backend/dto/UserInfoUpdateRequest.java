package com.cbl.backend.dto;


public class UserInfoUpdateRequest {

	
	private String firstName;
	private String lastName;
	private String role;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String username;
	
	
	
	
	
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
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "UserDetailsRequest [ firstName=" + firstName + ", lastName=" + lastName
				+ ", role=" + role + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLine3=" + addressLine3 + ", username=" + username + /*", password=" + password
				+ */", phoneNumbers="  + "]";
	}
}