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
	
	public Skill getSkill()
	{
		return skill;
	}
	
	public void setSkill(Skill skill)
	{
		this.skill = skill;
	}
	
	public LevelSkill getLevel()
	{
		return level;
	}
	
	public void setLevel(LevelSkill level)
	{
		this.level = level;
	}
	
}
