package com.dell.training.hibernateimpl.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dell.training.hibernateimpl.entity.Course;
import com.dell.training.hibernateimpl.entity.Passport;
import com.dell.training.hibernateimpl.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(StudentRepository.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addStudentWithPassport() {
		Passport passport = new Passport("P123456");
		this.entityManager.persist(passport);
		
		Student student = new Student("First", "first@mail.com");
		student.setPassport(passport);
		this.entityManager.persist(student);
	}
	
	public void updateStudentWithPassport() {
		Student student = this.entityManager.find(Student.class, 1);
		this.logger.info("Student : {}", student);
		
		Passport passport = student.getPassport();
		this.logger.info("Passport : {}", passport);
		
		passport.setNumber("N654321");
		
		student.setName("FirstPro");
		
	}
	
	public void relateStudentAndCourse() {
		Student student  = this.entityManager.find(Student.class, 1);
		Course course1 = this.entityManager.find(Course.class, 1);
		Course course2 = this.entityManager.find(Course.class, 2);
		
		student.addCourse(course1);
		student.addCourse(course2);
		
		course1.addStudent(student);
		course2.addStudent(student);
	}
	
	public void fetchStudentWithAllCourses() {
		Student student  = this.entityManager.find(Student.class, 1);
		this.logger.info("Student : {}", student);
		this.logger.info("Courses : {}", student.getCourses());
	}
}
