package com.skillsmanagement.dao;

import java.util.List;

import com.skillsmanagement.model.Skills;

public interface SkillsDao {
	Skills getSkillsById(int skillsId);

	List<Skills> getSkillsBySkillsGroupId(int skillsGroupId);

	void addSkills(Skills skills);

	void editSkills(Skills skills);

	void deleteSkills(Skills skills);
}
