package com.dibasb.mytracker.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashBoardController {

	
	
    @GetMapping("/")
    public ModelAndView dashboard(ModelMap model, Authentication auth){
        model.put("name", auth.getName());
        return new ModelAndView("welcome");
    }
}
