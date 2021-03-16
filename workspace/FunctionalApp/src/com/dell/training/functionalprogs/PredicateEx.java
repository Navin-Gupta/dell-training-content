package com.dell.training.functionalprogs;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.dell.training.repository.Student;
import com.dell.training.repository.StudentRepository;

public class PredicateEx {
	
	
	
	// Predicate for even
	static Predicate<Integer> isEven = val -> val %2 == 0;
	
	// Predicate to check if student is in grade greater than 2
	static Predicate<Student> isInGradeGreaterThanTwo =
			student -> student.getGrade() > 2;
			
	// Predicate to check if student has gpa greater than 3.5
	static Predicate<Student> hasGpaGreaterThanAverage =
			student -> student.getGpa() > 3.5;		
	
	// Consumer that accepts a student and display name
	static Consumer<Student> displayName =
			student -> System.out.println(student.getName());
			
	// Consumer that accepts a student and display activities
	static Consumer<Student> displayActivities =
			student -> System.out.println(student.getActivities());	
	
	// need to display name and activities of all students with grade greater than 2
	static void printNamesAndActivitiesWithCondition() {
		StudentRepository.getStudents().forEach(student->{
			if(isInGradeGreaterThanTwo.and(hasGpaGreaterThanAverage).test(student)) {
				
				displayName.andThen(displayActivities).accept(student);
				
			}
		});
	} 		
			
	public static void main(String args[]) {
		/*if(isEven.test(4)) {
			System.out.println("Yes Even!");
		}*/
		
		printNamesAndActivitiesWithCondition();
	}
}
