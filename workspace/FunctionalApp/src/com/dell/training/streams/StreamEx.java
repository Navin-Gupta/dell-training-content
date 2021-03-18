package com.dell.training.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.dell.training.repository.Student;
import com.dell.training.repository.StudentRepository;

public class StreamEx {

	// Predicate to check if student is in grade greater than 2
	static Predicate<Student> isInGradeGreaterThanTwo =
			student -> student.getGrade() > 2;
			
	// Predicate to check if student has gpa greater than 3.5
	static Predicate<Student> hasGpaGreaterThanAverage =
			student -> student.getGpa() > 3.5;		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*StudentRepository.getStudents()
		.stream().peek(student->System.out.println("Initiated :" + student))
		.filter(isInGradeGreaterThanTwo).peek(student->System.out.println("Ist Filter :" + student))
		.filter(hasGpaGreaterThanAverage).peek(student->System.out.println("IInd Filter :" + student))
		//.filter(isInGradeGreaterThanTwo.and(hasGpaGreaterThanAverage))
		.forEach(System.out::println);*/
		
		StudentRepository.getStudents()
		.stream().peek(student->System.out.println("Initiated :" + student))
		.filter(isInGradeGreaterThanTwo).peek(student->System.out.println("Ist Filter :" + student))
		.filter(hasGpaGreaterThanAverage).peek(student->System.out.println("IInd Filter :" + student));
		//.filter(isInGradeGreaterThanTwo.and(hasGpaGreaterThanAverage))
		// .forEach(System.out::println);
		
		/*List<Student> filteredStudents = StudentRepository.getStudents()
		.stream().peek(student->System.out.println("Initiated :" + student))
		.filter(isInGradeGreaterThanTwo).peek(student->System.out.println("Ist Filter :" + student))
		.filter(hasGpaGreaterThanAverage).peek(student->System.out.println("IInd Filter :" + student))
		.collect(Collectors.toList());*/
		
		
		/*Map<String, List<String>> studentMap = StudentRepository.getStudents()
				.stream().peek(student->System.out.println("Initiated :" + student))
				.filter(isInGradeGreaterThanTwo).peek(student->System.out.println("Ist Filter :" + student))
				.filter(hasGpaGreaterThanAverage).peek(student->System.out.println("IInd Filter :" + student))
				.collect(Collectors.toMap(student-> student.getName(), student -> student.getActivities()));*/
				
		
		
		
		/*Stream<Student> studentStream = StudentRepository.getStudents().stream();
		Stream<Student> studentStreamFiltered1 = studentStream.filter(isInGradeGreaterThanTwo);
		Stream<Student> studentStreamFiltered2 = studentStreamFiltered1.filter(hasGpaGreaterThanAverage);
		Stream<String> studentNameStream = studentStreamFiltered2.map(student -> student.getName());
		studentNameStream.forEach(System.out :: println);*/
		
		// IntStream.range(1, 50).sum();
		
	}

}








