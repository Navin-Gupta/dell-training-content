package com.dell.training.spring.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Component properties + registered as Controller under Handler Mapper
@Controller
public class HomeController {
	
	// Action method : containing the logic to process the request
	/*
	 * 1. Access Modifier : public 
	 * 2. Return type : string
	 * 3. Name : anything
	 * 4. Parameter : vary as per requirement
	 * 5. Annotated with : @RequestMapping
	 */
	
	// to map a url with the method 
	// eg : /xyz : if user request this url, current method shall handle that
	// url with method name get registered with Handler Mapper
	@RequestMapping("/")
	public String home() {
		// add business logic
		
		// must return the view page name
		return "index";
	}
	
	// mapping multiple url
	@RequestMapping(value = {"/contact","/contact-us","/connect","/support"})
	public String contact() {
		// add business logic
		
		// must return the view page name
		return "contact-us";
	}
}
