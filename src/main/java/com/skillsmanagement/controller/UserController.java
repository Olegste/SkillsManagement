package com.skillsmanagement.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class UserController {
	private Path path;
	@Autowired
	private UserService userService;

	@RequestMapping("/profile")
	public String viewProfile(Principal activeUser, Model model) throws IOException {
		User user = userService.getUserByUsername(activeUser.getName());
		System.out.println("Username:" + activeUser.getName());
		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping("/profile/editProfile")
	public String editUser(Model model, Principal activeUser, HttpServletRequest request) {
		User user = userService.getUserByUsername(activeUser.getName());
		model.addAttribute("user", user);
		return "editProfile";
	}

	@RequestMapping(value = "/profile/editProfile", method = RequestMethod.POST)
	public String editUserPost(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response, Principal principal) {

		if (result.hasErrors()) {
			return "editUserProfile";
		}

		userService.editUser(user);

		MultipartFile userImage = user.getUserImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + user.getUserId() + ".png");
		if (userImage != null && !userImage.isEmpty()) {
			try {
				userImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				throw new RuntimeException("User image saving failed", e);
			}
		}

		return "redirect:/profile";
	}

	@RequestMapping("/profile/deleteProfile")

	public String deleteCustomer(HttpServletRequest request, Principal activeUser) {

		User user = userService.getUserByUsername(activeUser.getName());
		userService.deleteUser(user);
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		SecurityContextHolder.clearContext();

		return "redirect:/login";
	}

}
