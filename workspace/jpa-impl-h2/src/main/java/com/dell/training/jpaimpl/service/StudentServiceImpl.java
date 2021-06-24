package com.dell.training.jpaimpl.service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dell.training.jpaimpl.entity.Student;
import com.dell.training.jpaimpl.exception.StudentNotFoundException;
import com.dell.training.jpaimpl.repository.StudentRepository;



// @Component
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<Student> getAllStudentRecords() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Student getStudentRecordById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Student> studentOptional = this.repository.findById(id);
		return studentOptional
				.map(student -> student) // Functional
				.orElseThrow(() -> new StudentNotFoundException("Student with id - " + id + " not found!!!")); // Supplier
		
	}

	@Override
	public Student addStudentRecord(Student student) {
		// TODO Auto-generated method stub
		// this.repository.someVeryComplexRequirement();*
		return this.repository.save(student); // upsert method
	}

	@Override
	public Student updateStudentRecord(Student student) {
		// TODO Auto-generated method stub
		return this.repository.save(student);
	}

	@Override
	public Student deleteStudentRecord(Integer id) {
		// TODO Auto-generated method stub
		Student student = this.getStudentRecordById(id);
		this.repository.deleteById(id);
		return  student;
	}

}
