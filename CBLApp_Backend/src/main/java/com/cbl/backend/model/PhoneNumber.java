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
	private int emp_p_id;
	@NotEmpty
	@Column(columnDefinition = "enum('office','home')")
	private String p_type;
	@NotEmpty
	@Column
	private String p_num;
	@ManyToOne
	private Employee emp;
	
	
	public int getEmp_p_id() {
		return emp_p_id;
	}
	public void setEmp_p_id(int emp_p_id) {
		this.emp_p_id = emp_p_id;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	@Override
	public String toString() {
		return "PhoneNumber [emp_p_id=" + emp_p_id + ", p_type=" + p_type + ", p_num=" + p_num + ", emp=" + emp + "]";
	}
}
