package com.brycen.hrm.payload.request;

import java.util.Date;


public class EmployeeRequest {

	private String fullname;
	
	private Date birthday;
	
	private boolean gender;
	
	private int departmentid;	

	private String address;
	
	private String phone;
	
	private String email;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullname() {
        return fullname;
    }
 
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
 
    public Date getBirthday() {
        return birthday;
    }
 
    public void setBirthday(Date birthday) {
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
    
    public int getDepartmentid()
    {
    	return departmentid;
    }
    
    public void setDepartmentid(int departmentId)
    {
    	this.departmentid = departmentId;
    }
}
