package com.dell.training.functionalprogs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.dell.training.repository.Student;
import com.dell.training.repository.StudentRepository;

public class FunctionEx {

	// will accept a string and return uppercase
	static Function<String, String> getUpperCase =
			str -> str.toUpperCase();
			
	// will accept a string and return extended string
	static Function<String, String> getExtended =
			str -> str.concat(" All");		
			
			
	// Predicate to check if student is in grade greater than 2
	static Predicate<Student> isInGradeGreaterThanTwo =
			student -> student.getGrade() > 2;	
			
			
	// to get name and gpa of student in grade greater than as map	
	static Function<List<Student>, Map<String, Double>> nameGpaData =
			students -> {
					Map<String, Double> nameGpaMap = new HashMap();
					students.forEach(student->{
						if(isInGradeGreaterThanTwo.test(student))
							nameGpaMap.put(student.getName(), student.getGpa());
					});
					return nameGpaMap;
			};
			
	// student Supplier
	static Supplier<List<Student>> allStudents =
			() -> StudentRepository.getStudents();
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("Upper Case : " + getUpperCase.apply("Hello"));
		
		// System.out.println("Extended and Converted : " + getExtended.andThen(getUpperCase).apply("Hello"));
		// System.out.println(nameGpaData.apply(StudentRepository.getStudents()));
		System.out.println(nameGpaData.apply(allStudents.get()));
		
		// java.util.function.
	}

}


















