package com.cbl.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminID;
	
	@OneToOne
	@JoinColumn(name = "userID")
	@JsonIgnore
	private User user;

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", user=" + user + "]";
	}
}
