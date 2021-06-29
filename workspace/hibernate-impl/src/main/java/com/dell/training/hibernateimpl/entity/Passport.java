package com.dell.training.hibernateimpl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String number;
	
	public Passport() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Passport(String number) {
		super();
		this.number = number;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}



	@Override
	public String toString() {
		return "\nPassport [id=" + id + ", number=" + number + "]";
	}
	
	
}
