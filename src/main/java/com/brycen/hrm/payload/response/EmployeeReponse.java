package com.brycen.hrm.payload.response;

import java.util.Date;

import com.brycen.hrm.model.Department;
import com.brycen.hrm.model.Employee;

public class EmployeeReponse {

	public Long id;
	public String fullname;
	public Date birthday;
	public boolean gender;
	public Department department;
	
	public EmployeeReponse(Employee employee) {
	    this.id = employee.getid();
	    this.fullname = employee.getFullname();
	    this.birthday = employee.getBirthday();
	    this.gender = employee.getGender();
	    this.department = employee.getDepartment();
	  }
	
	public Long getid()
	{
		return id;
	}
	
	public String getFullname()
	{
		return fullname;
	}
	
	public Date getBirthday()
	{
		return birthday;
	}
	
	public boolean getGender()
	{
		return gender;
	}
	
	public Department getDeparment()
	{
		return department;
	}
}
