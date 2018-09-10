package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebsiteController {
    @RequestMapping(value = "/")
    public String welcome() {
        return "welcome";
    }
}
