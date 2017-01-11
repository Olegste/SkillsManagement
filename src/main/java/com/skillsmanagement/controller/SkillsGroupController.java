package com.skillsmanagement.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skillsmanagement.model.Skills;
import com.skillsmanagement.model.SkillsGroup;
import com.skillsmanagement.model.User;
import com.skillsmanagement.service.SkillsGroupService;
import com.skillsmanagement.service.SkillsService;
import com.skillsmanagement.service.UserService;

@Controller
public class SkillsGroupController {

	@Autowired
	private UserService userService;

	@Autowired
	private SkillsGroupService skillsGroupService;

	@Autowired
	private SkillsService skillsService;

	@RequestMapping("/skillsGroup")
	public String viewSkillsGroupList(Model model, Principal activeUser) {
		User user = userService.getUserByUsername(activeUser.getName());
		List<SkillsGroup> skillsGroupList = skillsGroupService.getSkillsGroupByUserId(user.getUserId());
		model.addAttribute("skillsGroupList", skillsGroupList);
		return "skillsGroup";
	}

	@RequestMapping("/skillsGroup/addSkillsGroup")
	public String addSkillsGroup(Model model) {
		SkillsGroup skillsGroup = new SkillsGroup();

		model.addAttribute("skillsGroup", skillsGroup);

		return "addSkillsGroup";
	}

	@RequestMapping(value = "/skillsGroup/addSkillsGroup", method = RequestMethod.POST)
	public String addSkillsGroupPost(@Valid @ModelAttribute("skillsGroup") SkillsGroup skillsGroup,
			BindingResult result, HttpServletRequest request, Principal activeUser) {
		if (result.hasErrors()) {
			return "addSkillsGroup";
		}
		User user = userService.getUserByUsername(activeUser.getName());

		skillsGroup.setUser(user);
		skillsGroupService.addSkillsGroup(skillsGroup);
		return "redirect:/skillsGroup";
	}

	@RequestMapping("/skillsGroup/viewSkillsGroup/{skillsGroupId}")
	public String viewSkillsGroup(@PathVariable(value = "skillsGroupId") int skillsGroupId, Model model)
			throws IOException {

		SkillsGroup skillsGroup = skillsGroupService.getSkillsGroupById(skillsGroupId);
		Skills skills = new Skills();
		List<Skills> skillList = skillsService.getSkillsBySkillsGroupId(skillsGroupId);
		model.addAttribute("skillsGroup", skillsGroup);
		model.addAttribute("skillList", skillList);
		model.addAttribute("skills", skills);

		return "viewSkillsGroup";
	}

	@RequestMapping(value = "/skillsGroup/viewSkillsGroup/{skillsGroupId}", method = RequestMethod.POST)
	public String addSkills(@ModelAttribute("skills") Skills skills,
			@ModelAttribute("skillsGroup") SkillsGroup skillsGroup, Principal activeUser, Model model)
			throws IOException {
		skills.setSkillsGroup(skillsGroup);
		skillsService.addSkills(skills);

		return "redirect:/skillsGroup/viewSkillsGroup/{skillsGroupId}";
	}

}
