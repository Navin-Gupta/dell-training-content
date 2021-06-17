package com.dell.training.unittesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dell.training.unittesting.model.Student;
import com.dell.training.unittesting.service.StudentService;

@RestController
public class StudentController {

	// dependency on service
	@Autowired
	private StudentService service;
	
	@GetMapping("/student/byid/{id}")
	public Student getById(@PathVariable Integer id) {
		//Student student = this.service.getById(id);
		
		//return student;
		return new Student(1, "First", "first@mail.com");
	}
}
