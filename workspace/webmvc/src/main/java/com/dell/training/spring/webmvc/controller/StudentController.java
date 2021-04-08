package com.dell.training.spring.webmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dell.training.spring.webmvc.model.Student;





// import jakarta.validation.Valid;

//import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/dashboard") // /student/dashboard
	public String home() {
		return "student-home";
	}
	
	// show the profile page
	@RequestMapping("/profile") 
	public String profile(Model model) {
		Student student = new Student();
		student.setUname("First");
		student.setEmail("first@mail.com");
		model.addAttribute("student", student);
		return "student-profile";
	}
	
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute("student") Student stud, BindingResult result) {
		
		if(result.hasErrors()) {
			return "student-profile";
		}
		
		System.out.println("NAME :" + stud.getUname());
		System.out.println("NAME :" + stud.getEmail());
		
		
		// @ModelAttribute : by default added into Model container
		return "student-confirm";
	}
	
	
	
}
