package com.metacube.training.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	/**
	 * To show that user or admin logout from the account
     * @return login page
     */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("logout", "logout");
		return "login";
	}
	
	/**
	 * To show error in the page that username and password is wrong
     * @return login page
     */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorLoginPage(Model model) {
		model.addAttribute("error", "error");
		return "login";
	}
}

