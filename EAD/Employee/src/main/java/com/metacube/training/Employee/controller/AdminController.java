package com.metacube.training.Employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "admin/login";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		System.out.println("here");
		return "admin/dashboard";
	}
	
	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username) {
		System.out.println("here");
		return "admin/addemployee";
	}

}
