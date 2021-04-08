package com.dell.training.spring.webmvc.service;

import java.util.List;

import com.dell.training.spring.webmvc.model.Student;

public interface IStudentService {
	List<Student> findAllStudents();
	boolean addStudent(Student student);
}
