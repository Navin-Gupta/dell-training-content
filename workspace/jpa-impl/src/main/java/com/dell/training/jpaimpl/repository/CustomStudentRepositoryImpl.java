package com.dell.training.jpaimpl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dell.training.jpaimpl.entity.Student;

public class CustomStudentRepositoryImpl implements  CustomStudentRepository{

	// spring will inject dependency 
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Student> someVeryComplexRequirement() {
		// TODO Auto-generated method stub
		// this.entityManager.
		return null;
	}

}
