package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Rahul Sharma
 *
 */
@Controller
public class WebsiteController {

    @RequestMapping("/")
    public String home()
    {
        return "welcome";
    }
    
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(){
		
		return "welcome";
	}
}
