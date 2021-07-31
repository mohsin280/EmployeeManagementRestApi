package com.nagarro.emp.entitie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "emp_api_tb")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
	
	@Id
	@Column(name = "emp_code")
	private int empCode;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_location")
	private String empLocation;
	@Column(name = "emp_email")
	private String empEmail;
	@Column(name = "emp_dob")
	private String empDob;
	
	public Employee() {
		super();
	}

	public Employee(int empCode, String empName, String empLocation, String empEmail, String empDob) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.empLocation = empLocation;
		this.empEmail = empEmail;
		this.empDob = empDob;
	}

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpDob() {
		return empDob;
	}

	public void setEmpDob(String empDob) {
		this.empDob = empDob;
	}
	
	
}
