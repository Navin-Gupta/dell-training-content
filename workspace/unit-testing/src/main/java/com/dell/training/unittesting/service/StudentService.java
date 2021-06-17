package com.dell.training.unittesting.service;

import java.util.List;

import com.dell.training.unittesting.model.Student;

public interface StudentService {

	public List<Student> getAll();
	public Student getById(int id);
	public Student add(Student student);
}
