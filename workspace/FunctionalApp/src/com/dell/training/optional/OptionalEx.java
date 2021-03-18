package com.dell.training.optional;

import java.util.Optional;

import com.dell.training.repository.Student;

public class OptionalEx {

	public static String getStudentName() {
		// assume a Supplier , gets a student object from db, based on some condition
		// Student student = customSupplier.get();
		Student student = null;
		if(student != null)
			return student.getName();
		return null;
	}
	
	public static Optional<String> getStudentNameOptional() {
		// assume a Supplier , gets a student object from db, based on some condition
		// wrap data into optional
		// Student student = Optional.ofNullable(customSupplier.get());
		Optional<Student> student = Optional.ofNullable(null);
		/*if(student.isPresent())
			return student.map(Student :: getName);	*/// Optional<String>
		student.map(Student :: getName).orElse("Dummy");
		student.map(Student :: getName).orElseGet(()-> "Dummy");
		student.map(Student :: getName).orElseThrow(()-> new RuntimeException("Student not found!"));
			// return student.map(stud -> stud.getName());	// Optional<String>
		return Optional.empty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = getStudentName();
		
	}

}
