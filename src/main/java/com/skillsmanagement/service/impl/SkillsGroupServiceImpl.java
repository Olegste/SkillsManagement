package com.skillsmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsmanagement.dao.SkillsGroupDao;
import com.skillsmanagement.model.SkillsGroup;
import com.skillsmanagement.service.SkillsGroupService;

@Service
public class SkillsGroupServiceImpl implements SkillsGroupService {

	@Autowired
	private SkillsGroupDao skillsGroupDao;

	public SkillsGroup getSkillsGroupById(int skillsGroupId) {
		return skillsGroupDao.getSkillsGroupById(skillsGroupId);
	}

	public List<SkillsGroup> getSkillsGroupByUserId(int userId) {
		return skillsGroupDao.getSkillsGroupByUserId(userId);
	}

	public void addSkillsGroup(SkillsGroup skillsGroup) {
		skillsGroupDao.addSkillsGroup(skillsGroup);
	}

	public void editSkillsGroup(SkillsGroup skillsGroup) {
		skillsGroupDao.editSkillsGroup(skillsGroup);
	}

	public void deleteSkillsGroup(SkillsGroup skillsGroup) {
		skillsGroupDao.deleteSkillsGroup(skillsGroup);
	}

}
