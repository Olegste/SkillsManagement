package com.skillsmanagement.dao;

import java.util.List;

import com.skillsmanagement.model.SkillsGroup;

public interface SkillsGroupDao {

	SkillsGroup getSkillsGroupById(int skillsGroupId);

	List<SkillsGroup> getSkillsGroupByUserId(int userId);

	void addSkillsGroup(SkillsGroup skillsGroup);

	void editSkillsGroup(SkillsGroup skillsGroup);

	void deleteSkillsGroup(SkillsGroup skillsGroup);
}
