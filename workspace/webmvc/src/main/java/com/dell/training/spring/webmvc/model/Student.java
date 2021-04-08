package com.dell.training.spring.webmvc.model;

import java.util.LinkedHashMap;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;








// Java beans conventions
public class Student {
	
	@NotBlank(message = "Name is Required!")
	private String uname;
	
	private String email;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	@Min(2)
	private int freePasses;
	
	private LinkedHashMap<String, String> countries;
	
	public Student() {
		// dummy list of countries (can be fetched from DB)
		this.countries = new LinkedHashMap<String, String>();
		this.countries.put("FR", "France");
		this.countries.put("IN", "India");
		this.countries.put("GR", "Germany");
		this.countries.put("US", "USA");
		
	}
	
	
	
	public int getFreePasses() {
		return freePasses;
	}



	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}



	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUname() {
		return this.uname;
	}
	public void setUname(String uname) {
		System.out.println("\nSetting Uname...");
		this.uname = uname;
	}
	public String getEmail() {
		if(this.email == null)
			this.email = "check@mail.com";
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
		System.out.println("\nSetting Email...");
		if(this.email == "")
			this.email = "test@mail.com";
	}



	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}



	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}



	public String[] getOperatingSystems() {
		return operatingSystems;
	}



	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
	
}
