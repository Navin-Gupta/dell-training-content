package com.dell.training.spring.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentor")
public class MentorController {

	@RequestMapping("/dashboard") // /mentor/dashboard
	public String home() {
		return "mentor-home";
	}
}
