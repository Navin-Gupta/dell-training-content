package com.dell.training.repository;

import java.util.List;

public class Student {
	private String name;
	private int grade;
	private double gpa;
	private String gender;
	private List<String> activities;
	
	
	
	public Student(String name, int grade, double gpa, String gender, List<String> activities) {
		super();
		this.name = name;
		this.grade = grade;
		this.gpa = gpa;
		this.gender = gender;
		this.activities = activities;
	}
	
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", gpa=" + gpa + ", gender=" + gender + ", activities="
				+ activities + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getActivities() {
		return activities;
	}
	public void setActivities(List<String> activities) {
		this.activities = activities;
	}
	
	
	
}
