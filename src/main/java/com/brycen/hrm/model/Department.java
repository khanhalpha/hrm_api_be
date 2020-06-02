package com.brycen.hrm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private Integer departmentId;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "department_name")
	private String departmentName;

	@NotBlank
	@Size(max = 50)
	@Column(name = "department_short")
	private String departmentShort;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	private Set<Employee> listEmployee = new HashSet<>();
	
	public Department() {

	}

	public Department(String departmentName, String departmentShort) {
		this.departmentName = departmentName;
		this.departmentShort = departmentShort;
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

	@Override
	public String toString() {
		return "Department [Id=" + departmentId + ", Name=" + departmentName + ", Short=" + departmentShort +  "]";
	}
}
