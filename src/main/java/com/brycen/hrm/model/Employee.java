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
	private String fullname;	
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "gender")
	private boolean gender;
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
    private Department department;
	
	public Employee() {

	}
	
	public Employee(String fullname, Date birthday, boolean gender, Department dep) {
		this.fullname = fullname;
		this.birthday = birthday;
		this.gender = gender;
		this.department = dep;
	}
	
	public Long getid()
	{
		return employeeId;
	}
	
	public String getFullname()
	{
		return fullname;
	}
	
	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}
	
	public Date getBirthday()
	{
		return birthday;
	}
	
	public void setBirthDay(Date birthday)
	{
		this.birthday = birthday;
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
