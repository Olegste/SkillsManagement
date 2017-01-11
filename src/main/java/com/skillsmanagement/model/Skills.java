package com.skillsmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skills {
	@Id
	@GeneratedValue
	private int id;
	private String skillName;
	private int rating;

	@ManyToOne
	@JoinColumn(name = "skillsGroupId")
	private SkillsGroup skillsGroup;

	public SkillsGroup getSkillsGroup() {
		return skillsGroup;
	}

	public void setSkillsGroup(SkillsGroup skillsGroup) {
		this.skillsGroup = skillsGroup;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
