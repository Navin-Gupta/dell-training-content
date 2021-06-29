package com.dell.training.hibernateimpl.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	
	public Course(String name) {
		super();
		this.name = name;
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
	@Override
	public String toString() {
		return "\nCourse [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
