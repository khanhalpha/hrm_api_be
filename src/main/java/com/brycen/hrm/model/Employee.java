package com.brycen.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private long employeeId;
	
	@Column(name = "fullname")
	private String fullName;	
	
	@Column(name = "birthday")
	private Date birthDay;
	
	@Column(name = "gender")
	private boolean gender;
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
    private Department department;
	
	public Employee() {

	}
	
	public Employee(String fullname, Date birthDay, boolean gender, Department dep) {
		this.fullName = fullname;
		this.birthDay = birthDay;
		this.gender = gender;
		this.department = dep;
	}
	
	public String getFullName()
	{
		return fullName;
	}
	
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	
	public Date getBirthDay()
	{
		return birthDay;
	}
	
	public void setBirthDay(Date birthDay)
	{
		this.birthDay = birthDay;
	}
	
	public boolean getGender()
	{
		return gender;
	}
	
	public void setGender(boolean gender)
	{
		this.gender = gender;
	}
	
	public Department getDepartment()
	{
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
}
