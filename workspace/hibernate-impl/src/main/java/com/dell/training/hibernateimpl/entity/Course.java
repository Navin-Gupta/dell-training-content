package com.dell.training.hibernateimpl.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@NamedQueries(value = {
		@NamedQuery(name = "retrieve_all", query = "select c from Course c"),
		@NamedQuery(name = "retrieve_conditional", query = "select c from Course c where c.id=:courseid")
})
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String name;
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<Student>();
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Course(String name) {
		super();
		this.name = name;
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
	public List<Student> getStudents() {
		return students;
	}



	public void setStudents(List<Student> students) {
		this.students = students;
	}



	@Override
	public String toString() {
		return "\nCourse [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
