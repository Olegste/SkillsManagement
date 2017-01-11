package com.skillsmanagement.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.skillsmanagement.model.User;
import com.skillsmanagement.service.UserService;

@Controller
public class RegisterController {

	private Path path;
	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String registerCustomer(Model model, Principal activeUser) {

		String register;
		User user = new User();

		model.addAttribute("user", user);

		if (activeUser == null) {
			register = "register";
		} else {
			register = "redirect:/home";

		}

		return register;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerCustomerPost(@Valid @ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request, Model model) {
		if (result.hasErrors()) {
			return "register";
		}
		List<User> userList = userService.getUserList();
		for (int i = 0; i < userList.size(); i++) {
			if (user.getUserEmail().equals(userList.get(i).getUserEmail())) {
				model.addAttribute("emailMsg", "Email already exists");
				return "register";
			}
			if (user.getUsername().equals(userList.get(i).getUsername())) {
				model.addAttribute("usernameMsg", "Username already exists");
				return "register";
			}
		}
		userService.addUser(user);

		// start add image
		MultipartFile userImage = user.getUserImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + user.getUserId() + ".png");
		System.out.println(path);
		if (userImage != null && !userImage.isEmpty()) {
			try {
				userImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				throw new RuntimeException("User image saving failed", e);
			}
		}

		return "redirect:/home";
	}

}