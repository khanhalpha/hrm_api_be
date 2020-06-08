package com.brycen.hrm.payload.response;

import com.brycen.hrm.model.Department;

public class DepartmentReponse {

	private Integer departmentId;
	private String departmentName;
	private String departmentShort;
	
	public DepartmentReponse() {
	}
	
	public DepartmentReponse(Department department) {
		this.departmentName = department.getDepartmentName();
		this.departmentShort = department.getDepartmentShort();
	}

	public long getId() {
		return departmentId;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentShort(String departmentShort) {
		this.departmentShort = departmentShort;
	}

	public String getDepartmentShort() {
		return departmentShort;
	}
}
