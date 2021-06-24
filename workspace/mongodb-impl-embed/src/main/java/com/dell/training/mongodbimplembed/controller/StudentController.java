package com.dell.training.mongodbimplembed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dell.training.mongodbimplembed.document.Student;
import com.dell.training.mongodbimplembed.exception.StudentNotFoundException;
import com.dell.training.mongodbimplembed.model.ExceptionResponse;
import com.dell.training.mongodbimplembed.service.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> students = this.service.getAllStudentRecords();
		ResponseEntity<List<Student>> response = 
				new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/students/{id}")
	public Student getById(@PathVariable String id){
		return this.service.getStudentRecordById(id);
	}
	
	@PostMapping("/students")
	public Student add(@RequestBody Student student){
		return this.service.addStudentRecord(student);
	}
	
	@PutMapping("/students")
	public Student update(@RequestBody Student student){
		return this.service.updateStudentRecord(student);
	}

	@DeleteMapping("/students/{id}")
	public Student delete(@PathVariable String id){
		return this.service.deleteStudentRecord(id);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleStudentNotFoundException(StudentNotFoundException ex) {
		ExceptionResponse exResponse = 
				new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		ResponseEntity<ExceptionResponse> response = 
				new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
		return response;
				 
	}

}











