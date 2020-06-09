package com.brycen.hrm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "skills")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private Long skillId;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "skill_name")
	private String skillName;

	@NotBlank
	@Size(max = 50)
	@Column(name = "skill_description")
	private String skillDescription;
	
	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private List<EmployeeSkill> empSkills;
	
	public Skill() {

	}

	public Skill(String skillName, String skillDescription) {
		this.skillName = skillName;
		this.skillDescription = skillDescription;
	}

	public long getId() {
		return skillId;
	}

	public void setSkillname(String skillName) {
		this.skillName = skillName;
	}
	
	public String getSkillname() {
		return skillName;
	}
	
	public void setSkilldescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	
	public String getSkilldescription() {
		return skillDescription;
	}
}
