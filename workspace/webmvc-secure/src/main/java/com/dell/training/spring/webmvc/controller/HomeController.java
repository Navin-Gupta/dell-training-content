package com.dell.training.spring.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Component properties + registered as Controller under Handler Mapper
@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String home() {
		// add business logic
		
		// must return the view page name
		return "index";
	}
	
	
}
