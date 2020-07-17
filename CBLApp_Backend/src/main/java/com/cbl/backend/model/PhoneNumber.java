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
	private int employeePhoneNumberID;
	@NotEmpty
	@Column(columnDefinition = "enum('Office','Home')")
	private String phoneType;
	@NotEmpty
	@Column
	private String phoneNumber;
	@ManyToOne
	private Employee employee;
	
	
	public int getEmployeePhoneNumberID() {
		return employeePhoneNumberID;
	}
	public void setEmployeePhoneNumberID(int employeePhoneNumberID) {
		this.employeePhoneNumberID = employeePhoneNumberID;
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "PhoneNumber [employeePhoneNumberID=" + employeePhoneNumberID + ", phoneType=" + phoneType
				+ ", phoneNumber=" + phoneNumber + ", employee=" + employee + "]";
	}
}
