package com.metacube.training.Employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

  
    
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getEmployee() {
        
        return new ModelAndView("employee/login","message","Get Method");
    
    }
    
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ModelAndView saveEmployee() {
        
    	return new ModelAndView("home","message","Post Method");
    }
 
}
