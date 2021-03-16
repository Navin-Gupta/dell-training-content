package com.dell.training.functionalprogs;

import java.util.function.Consumer;

import com.dell.training.repository.Student;
import com.dell.training.repository.StudentRepository;

public class ConsumerEx {

	// Consumer that accepts a student and display name
	static Consumer<Student> displayName =
			student -> System.out.println(student.getName());
			
	// Consumer that accepts a student and display activities
	static Consumer<Student> displayActivities =
			student -> System.out.println(student.getActivities());		
	
	// need to display name of all students
	static void printNames() {
		StudentRepository.getStudents().forEach(displayName);
	}
	
	// need to display name and activities of all students
	static void printNamesAndActivities() {
		/*StudentRepository.getStudents().forEach(displayName);
		StudentRepository.getStudents().forEach(displayActivities);*/
		StudentRepository.getStudents().forEach(displayName.andThen(displayActivities));
	}
	
	// need to display name and activities of all students with grade greater than 2
	static void printNamesAndActivitiesWithCondition() {
		/*for(Student student : StudentRepository.getStudents()) {
			// mutable
		}*/
		
		// immutable
		StudentRepository.getStudents().forEach(student->{
			if(student.getGrade() > 2) {
				// displayName.accept(student);
				displayName.andThen(displayActivities).accept(student);
				// can be called on a single consumer or chain of consumer
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<String> c1 = str -> System.out.println(str.toUpperCase());
		
		// c1.accept("Hello");
		// printNames();
		// printNamesAndActivities();
		printNamesAndActivitiesWithCondition();
	}

}
