package com.skillsmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsmanagement.dao.SkillsDao;
import com.skillsmanagement.model.Skills;
import com.skillsmanagement.service.SkillsService;

@Service
public class SkillsServiceImpl implements SkillsService {

	@Autowired
	private SkillsDao skillsDao;

	public Skills getSkillsById(int skillsId) {
		return skillsDao.getSkillsById(skillsId);
	}

	public List<Skills> getSkillsBySkillsGroupId(int skillsGroupId) {
		return skillsDao.getSkillsBySkillsGroupId(skillsGroupId);
	}

	public void addSkills(Skills skills) {
		skillsDao.addSkills(skills);
	}

	public void editSkills(Skills skills) {
		skillsDao.editSkills(skills);
	}

	public void deleteSkills(Skills skills) {
		skillsDao.deleteSkills(skills);
	}

}
