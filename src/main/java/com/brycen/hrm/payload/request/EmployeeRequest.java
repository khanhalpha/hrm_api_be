package com.brycen.hrm.payload.request;

import java.util.Date;


public class EmployeeRequest {

	private String fullname;
	
	private Date birthday;
	
	private boolean gender;
	
	private int departmentid;
	
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
