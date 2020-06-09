package com.brycen.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_skill")
public class EmployeeSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empskill_id")
	private long empskillId;
	
	@ManyToOne 
    @JoinColumn(name = "employee_id")
	private Employee employee;	
//	
	@ManyToOne 
    @JoinColumn(name = "skill_id")
	private Skill skill;
	
	@OneToOne
	@JoinColumn(name = "level_id")
	private LevelSkill level;
	
	public EmployeeSkill()
	{
		
	}
	
	public EmployeeSkill(Employee employee, Skill skill, LevelSkill level)
	{
		this.employee = employee;
		this.skill = skill;
		this.level = level;
	}
	
	public Long getEmployeeskillid()
	{
		return empskillId;
	}
	
	public Skill getskill()
	{
		return skill;
	}
	
	public void setskill(Skill skill)
	{
		this.skill = skill;
	}
	
	public LevelSkill getlevel()
	{
		return level;
	}
	
	public void setlevel(LevelSkill level)
	{
		this.level = level;
	}
	
}
