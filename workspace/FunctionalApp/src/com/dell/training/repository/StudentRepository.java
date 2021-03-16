package com.dell.training.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepository {

	public static List<Student> getStudents(){
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("First", 2, 3.6, "Male", Arrays.asList("Swimming", "Basketball")));
		students.add(new Student("Second", 2, 3.8, "Female", Arrays.asList("Swimming", "Basketball", "Gymnastics")));
		students.add(new Student("Third", 3, 4.0, "Male", Arrays.asList("Swimming", "Vollyball")));
		students.add(new Student("Fourth", 4, 3.9, "Female", Arrays.asList("Football", "Basketball")));
		students.add(new Student("Fifth", 4, 3.3, "Male", Arrays.asList("Swimming", "Vollyball")));
		
		return students;
	}
}
