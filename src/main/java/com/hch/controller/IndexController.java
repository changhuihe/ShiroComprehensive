package com.hch.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hch.bind.CurrentUser;
import com.hch.entity.Resource;
import com.hch.entity.User;
import com.hch.service.ResourceService;
import com.hch.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private ResourceService resourceService;
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index(@CurrentUser User loginUser, Model model) {
		Set<String> permissions = userService.findPermissions(loginUser.getUsername());
		List<Resource> menus = resourceService.findMenus(permissions);
		model.addAttribute("menus", menus);
		return "index";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}