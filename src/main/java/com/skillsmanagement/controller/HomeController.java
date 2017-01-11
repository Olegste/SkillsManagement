package com.skillsmanagement.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skillsmanagement.model.User;
import com.skillsmanagement.service.UserService;

@Controller

public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String home() {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String homeJsp() {
		return "index";
	}

	@RequestMapping("/news")
	public String news(Principal activeUser) {
		User user = userService.getUserByUsername(activeUser.getName());
		System.out.println(user);
		return "news";
	}

	@RequestMapping("/login")
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal activeUser) {

		String login;
		if (error != null) {
			model.addAttribute("error", "Invalid username or password");
		}
		if (logout != null) {
			model.addAttribute("msg", "You have been logout succesfully");
		}
		if (activeUser == null) {
			login = "login";
		} else {
			login = "redirect:/home";

		}
		return login;
	}

}
