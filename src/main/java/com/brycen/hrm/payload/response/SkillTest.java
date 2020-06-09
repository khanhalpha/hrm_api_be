package com.brycen.hrm.payload.response;

public class SkillTest {

	private Long empSkillid;
	private Long skillId;
	private Long levelId;
	
	public Long getEmpskill()
	{
		return empSkillid;
	}
	
	public void setEmpskill(Long empSkillId)
	{
		this.empSkillid  = empSkillId;
	}
	
	public Long getSkill()
	{
		return skillId;
	}
	
	public void setSkill(Long skill)
	{
		this.skillId = skill;
	}
	
	public Long getLevel()
	{
		return levelId;
	}
	
	public void setLevel(Long level)
	{
		this.levelId = level;
	}
}
