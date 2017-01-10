package com.skillsmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.skillsmanagement.model.Skills;
import com.skillsmanagement.model.SkillsGroup;
import com.skillsmanagement.service.SkillsGroupService;
import com.skillsmanagement.service.SkillsService;

@Controller
@RequestMapping("/rest/skills")
public class SkillsResources {

	@Autowired
	private SkillsService skillsService;
	@Autowired
	private SkillsGroupService skillsGroupService;

	@RequestMapping("/{skillsGroupId}")
	public @ResponseBody SkillsGroup getSkillsGroupById(@PathVariable(value = "skillsGroupId") int skillsGroupId) {
		return skillsGroupService.getSkillsGroupById(skillsGroupId);
	}

	@RequestMapping(value = "/add/{skillsGroupId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addSkills(@PathVariable(value = "skillsGroupId") int skillsGroupId,
			@AuthenticationPrincipal User activeUser) {
		Skills skills = new Skills();
		SkillsGroup skillsGroup = skillsGroupService.getSkillsGroupById(skillsGroupId);
		skills.setSkillsGroup(skillsGroup);
		skillsService.addSkills(skills);
	}
}
