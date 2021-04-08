package com.dell.training.spring.webmvc.dao;

import java.util.List;

import com.dell.training.spring.webmvc.model.Student;

public interface IStudentDao {
	
	List<Student> findAll();
	boolean add(Student student);
}
