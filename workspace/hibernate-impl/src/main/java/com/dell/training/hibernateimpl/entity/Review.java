package com.dell.training.hibernateimpl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer rating;
	
	private String review;
	
	@ManyToOne
	private Course course;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Review(Integer rating, String review) {
		super();
		this.rating = rating;
		this.review = review;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", review=" + review + ", course=" + course + "]";
	}
	
	
}
