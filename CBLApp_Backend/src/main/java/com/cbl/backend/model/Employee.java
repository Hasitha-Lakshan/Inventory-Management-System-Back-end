package com.cbl.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	@NotEmpty
	@Column
	private String f_name;
	@NotEmpty
	@Column
	private String l_name;
	@NotEmpty
	@Column
	private String rol;
	@NotEmpty
	@Column
	private String add_line_1;
	@NotEmpty
	@Column
	private String add_line_2;
	@NotEmpty
	@Column
	private String add_line_3;
	@NotEmpty
	@Column
	private String u_name;
	@NotEmpty
	@Column
	private String pass;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "emp")
	private List<PhoneNumber> p_nums;
	
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getAdd_line_1() {
		return add_line_1;
	}
	public void setAdd_line_1(String add_line_1) {
		this.add_line_1 = add_line_1;
	}
	public String getAdd_line_2() {
		return add_line_2;
	}
	public void setAdd_line_2(String add_line_2) {
		this.add_line_2 = add_line_2;
	}
	public String getAdd_line_3() {
		return add_line_3;
	}
	public void setAdd_line_3(String add_line_3) {
		this.add_line_3 = add_line_3;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<PhoneNumber> getP_nums() {
		return p_nums;
	}
	public void setP_nums(List<PhoneNumber> p_nums) {
		this.p_nums = p_nums;
	}
	
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", f_name=" + f_name + ", l_name=" + l_name + ", rol=" + rol
				+ ", add_line_1=" + add_line_1 + ", add_line_2=" + add_line_2 + ", add_line_3=" + add_line_3
				+ ", u_name=" + u_name + ", pass=" + pass + ", p_nums=" + p_nums + "]";
	}
}
