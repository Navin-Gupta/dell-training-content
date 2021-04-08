package com.dell.training.spring.webmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dell.training.spring.webmvc.dao.IStudentDao;
import com.dell.training.spring.webmvc.model.Student;

@Component
public class StudentServiceImpl implements IStudentService {

	// dependency on DAO layer
	// @Autowired
	private IStudentDao studentDao;
	
	@Autowired
	public StudentServiceImpl(IStudentDao studentDao) {
		// TODO Auto-generated constructor stub
		this.studentDao = studentDao;
	}
	
	
	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return this.studentDao.findAll();
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return this.studentDao.add(student);
	}

}
