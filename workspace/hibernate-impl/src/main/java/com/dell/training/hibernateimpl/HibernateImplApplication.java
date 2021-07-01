package com.dell.training.hibernateimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dell.training.hibernateimpl.entity.Course;
import com.dell.training.hibernateimpl.repository.CourseRepository;
import com.dell.training.hibernateimpl.repository.ReviewRepository;
import com.dell.training.hibernateimpl.repository.StudentRepository;

@SpringBootApplication
public class HibernateImplApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(HibernateImplApplication.class);
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private StudentRepository studentRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateImplApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Course course = new Course("Spring Boot");
		// Course saved = this.repository.saveCourse(course);
		// Course saved = this.repository.saveCoursePro(course);
		// this.repository.saveCourseExperiment();
		
		// this.repository.addStudentWithPassport();
		// this.repository.updateStudentWithPassport();
		// this.logger.debug(saved.toString());
		this.courseRepository.saveCourseExperiment();
		this.courseRepository.addCourseWithReviews();
		this.studentRepository.addStudentWithPassport();
		this.studentRepository.relateStudentAndCourse();
		// this.studentRepository.fetchStudentWithAllCourses();
		this.courseRepository.fetchCourseWithStudent();
		// this.repository.fetchCourse();
		// this.reviewRepository.fetchReview();
	}

}
