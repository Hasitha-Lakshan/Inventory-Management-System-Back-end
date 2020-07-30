package com.cbl.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

	
	@Entity
	@Table(name = "Lorry")
	public class Lorry {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int lorryID;
		@NotEmpty
		@Column
		private String firstName;
		@NotEmpty
		@Column
		private String lastName;
		@NotEmpty
		@Column
		private int phonenumber;
		@NotEmpty
		@Column
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
			return "Lorry [lorryID=" + lorryID + ", firstName=" + firstName + ", lastName=" + lastName + ", phonenumber=" + phonenumber + "]";
		}	
		

}
