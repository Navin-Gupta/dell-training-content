package com.dell.training.jpaimpl.service;

import java.util.List;

import com.dell.training.jpaimpl.entity.Student;

public interface StudentService {

	public List<Student> getAllStudentRecords();
	
	public Student getStudentRecordById(Integer id);
	
	public Student addStudentRecord(Student student);
	
	public Student updateStudentRecord(Student student);
	
	public Student deleteStudentRecord(Integer id);
}
