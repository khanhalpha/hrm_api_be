package com.brycen.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "levelskills")
public class LevelSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "level_id")
	private Long levelId;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "level_name")
	private String levelName;

	@NotBlank
	@Size(max = 100)
	@Column(name = "level_description")
	private String levelDescription;
	
	@Column(name = "level_number")
	private String levelNumber;

	public LevelSkill() {

	}

	public LevelSkill(String levelName, String levelDescription) {
		this.levelName = levelName;
		this.levelDescription = levelDescription;
	}
	
	public long getId() {
		return levelId;
	}

	public void setLevelname(String levelName) {
		this.levelName = levelName;
	}
	
	public String getLevelname()
	{
		return levelName;
	}
	
	public void setLevelDescription(String levelDescription)
	{
		this.levelDescription = levelDescription;
	}
	
	public String getLeveldescription()
	{
		return levelDescription;
	}
	
	public String getLevelnumber() {
		return levelNumber;
	}

	public void setLevelNumber(String levelNumber) {
		this.levelNumber = levelNumber;
	}
}
