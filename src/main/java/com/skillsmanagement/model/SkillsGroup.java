package com.skillsmanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SkillsGroup {
	@Id
	@GeneratedValue
	private int skillsGroupId;
	private String groupName;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "skillsGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Skills> listSkills;

	public List<Skills> getListSkills() {
		return listSkills;
	}

	public void setListSkills(List<Skills> listSkills) {
		this.listSkills = listSkills;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getSkillsGroupId() {
		return skillsGroupId;
	}

	public void setSkillsGroupId(int skillsGroupId) {
		this.skillsGroupId = skillsGroupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
