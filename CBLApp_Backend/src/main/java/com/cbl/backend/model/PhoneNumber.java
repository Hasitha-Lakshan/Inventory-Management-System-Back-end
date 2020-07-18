package com.cbl.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "PhoneNumbers")
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userPhoneNumberID;
	@NotEmpty
	@Column(columnDefinition = "enum('Office','Home')")
	private String phoneType;
	@NotEmpty
	@Column
	private String phoneNumber;
	@ManyToOne
	private User user;
	
	
	public int getUserPhoneNumberID() {
		return userPhoneNumberID;
	}
	public void setUserPhoneNumberID(int userPhoneNumberID) {
		this.userPhoneNumberID = userPhoneNumberID;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PhoneNumber [userPhoneNumberID=" + userPhoneNumberID + ", phoneType=" + phoneType + ", phoneNumber="
				+ phoneNumber + ", user=" + user + "]";
	}
}
