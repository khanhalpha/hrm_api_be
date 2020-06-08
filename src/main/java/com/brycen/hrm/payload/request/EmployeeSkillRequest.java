package com.brycen.hrm.payload.request;

import java.util.List;

import com.brycen.hrm.model.EmployeeSkill;

public class EmployeeSkillRequest {

	private List<EmployeeSkill> empSkills;
	
	public List<EmployeeSkill> getListEmpSkill()
	{
		return empSkills;
	}
	
	public void setListEmpSkill(List<EmployeeSkill> list)
	{
		this.empSkills = list;
	}
}
