package com.dell.training.mongodbimplembed.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.dell.training.mongodbimplembed.document.Student;

public class CustomStudentRepositoryImpl implements CustomStudentRepository{

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void customMethod() {
		// TODO Auto-generated method stub
		
		this.mongoTemplate.insert(new Student());
		List<Student> students = new ArrayList<Student>();
		this.mongoTemplate.insert(students);
		
		this.mongoTemplate.save(new Student(), "associates");
		this.mongoTemplate.collectionExists(Student.class);
		
		Query query = new Query();
		query.addCriteria(Criteria.where("age").is(23));
		// query.addCriteria(Criteria.where("age").is(23));
		
		List<Student> studentList = this.mongoTemplate.find(query, Student.class, "associate");
	}

}
