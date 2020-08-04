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
@Table(name = "Analyzers")
public class Analyzer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int analyzerID;
	
	@OneToOne
	@JoinColumn(name = "userID")
	@JsonIgnore
	private User user;

	public int getAnalyzerID() {
		return analyzerID;
	}

	public void setAnalyzerID(int analyzerID) {
		this.analyzerID = analyzerID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Analyzer [analyzerID=" + analyzerID + ", user=" + user + "]";
	}
}
