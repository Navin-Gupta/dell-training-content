package com.dell.training.spring.webmvc.model;


import javax.validation.constraints.NotBlank;

// Java beans conventions
public class Student {
	
	@NotBlank(message = "Name is Required!")
	private String uname;
	
	private String email;
	
	
	public Student() {
		
		
	}
	
	
	
	
	public String getUname() {
		return this.uname;
	}
	public void setUname(String uname) {
		// System.out.println("\nSetting Uname...");
		this.uname = uname;
	}
	public String getEmail() {
		/*if(this.email == null)
			this.email = "check@mail.com";*/
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
		/*System.out.println("\nSetting Email...");
		if(this.email == "")
			this.email = "test@mail.com";*/
	}



	
	
}
