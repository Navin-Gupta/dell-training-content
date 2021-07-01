package com.dell.training.hibernateimpl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dell.training.hibernateimpl.entity.Course;
import com.dell.training.hibernateimpl.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(CourseRepository.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Course saveCourse(Course course) {
		if(course.getId() == null) {
			// if entity/record already exits, it throws an exception
			this.entityManager.persist(course);
		} else {
			this.entityManager.merge(course);
		}
		return course;
	}
	
	public Course saveCoursePro(Course course) {
		
			this.entityManager.persist(course);
		
			course.setName("ReactJS");
		
			return course;
	}
	
	public void saveCourseExperiment() {
		
		Course course1 = new Course("Spring Boot");
		this.entityManager.persist(course1);
		
	
		Course course2 = new Course("ReactJS");
		this.entityManager.persist(course2);
		
		this.entityManager.flush();
		
		this.entityManager.detach(course1);
		
		course1.setName("Spring MVC");
		course2.setName("Angular");
		
	}
	
	public void jpaUsingNativeQuery() {
		//Query query = this.entityManager.createNativeQuery("select * from Course", Course.class);
		
		Query query = this.entityManager.createNativeQuery("select * from Course where id = ?", Course.class);
		query.setParameter(1, 5);
		
		List courses = query.getResultList();
		
		// query.executeUpdate(); // for Insert,Update, Delete
	}
	
	public void jpaUsingNamedQuery() {
		// Query query = this.entityManager.createNamedQuery("retrieve_all", Course.class);
		
		TypedQuery<Course> query = this.entityManager.createNamedQuery("retrieve_conditional", Course.class);
		query.setParameter("courseid", 5);
		query.setParameter(1, 5);
		
		List<Course> courses = query.getResultList();
		
		// query.executeUpdate(); // for Insert,Update, Delete
	}
	
	public void addCourseWithReviews() {
		
		Course course = this.entityManager.find(Course.class, 1);
		this.logger.info("reviews : {}", course.getReviews());
		
		Review review1 = new Review(4, "Nice Contents");
		Review review2 = new Review(5, "Great Help!");
		
		course.addReview(review1);
		review1.setCourse(course);// DB relation
		
		course.addReview(review2);
		review2.setCourse(course);
		
		this.entityManager.persist(review1);
		this.entityManager.persist(review2);
		
	}
	
	public void fetchCourse() {
		Course course = this.entityManager.find(Course.class, 1);
		this.logger.info("reviews : {}", course.getReviews());
	}
	
	public void fetchCourseWithStudent() {
		Course course = this.entityManager.find(Course.class, 1);
		this.logger.info("Course : {}", course);
		this.logger.info("Students : {}", course.getStudents());
	}
	
}
