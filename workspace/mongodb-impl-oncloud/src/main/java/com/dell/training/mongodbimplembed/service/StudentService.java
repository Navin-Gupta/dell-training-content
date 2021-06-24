package com.dell.training.mongodbimplembed.service;

import java.util.List;

import com.dell.training.mongodbimplembed.document.Student;



public interface StudentService {

	public List<Student> getAllStudentRecords();
	
	public Student getStudentRecordById(String id);
	
	public Student addStudentRecord(Student student);
	
	public Student updateStudentRecord(Student student);
	
	public Student deleteStudentRecord(String id);
}
