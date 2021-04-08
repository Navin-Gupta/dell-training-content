package com.dell.training.spring.webmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dell.training.spring.webmvc.model.Student;
import com.dell.training.spring.webmvc.service.IStudentService;





// import jakarta.validation.Valid;

//import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	// dependency
	private IStudentService studentService;
	
	@Autowired
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	
	@RequestMapping("/dashboard") // /student/dashboard
	public String home() {
		return "student-home";
	}
	
	@RequestMapping("/list") 
	public String list(Model model) {
		// fetch from DB via service
		List<Student> students = this.studentService.findAllStudents();
		
		// share list with view page
		model.addAttribute("students", students);
		return "student-list";
	}
	
	
	// show the profile page
	@RequestMapping("/profile") 
	public String profile(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-profile";
	}
	
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		
		if(result.hasErrors()) {
			return "student-profile";
		}
		
		// send the student object to DAO layer via Service
		this.studentService.addStudent(student);
		// revert back with the student list page
		return "redirect:/student/list";
	}
	
	
	
}
