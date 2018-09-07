package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/project")
public class ProjectController {

    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String adminAddProject() {
        return "admin/addEmployee";
    }
    
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String adminAddProject(@RequestParam("username") String username,
            @RequestParam("password") String password) {
        return "";
    }
}
