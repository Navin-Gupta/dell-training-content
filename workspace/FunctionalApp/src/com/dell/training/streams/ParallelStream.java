package com.dell.training.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.dell.training.repository.Student;
import com.dell.training.repository.StudentRepository;

public class ParallelStream {

	static List<String> seqStreamCase(){
		 
		long start = System.currentTimeMillis();
		List<String> activities = StudentRepository.getStudents()
		.stream().peek(student -> System.out.println("Stream : " + student))
		.map(student -> student.getActivities()).peek(list -> System.out.println("MAP :" + list )) // Stream<<List<String>>
		.flatMap(list -> list.stream()).peek(activity -> System.out.println("FlatMap : " + activity))
		.collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		System.out.println("\nSequential Time : " + (end-start) + "\n");
		return activities;
	}
	
	static List<String> parallelStreamCase(){
		 
		long start = System.currentTimeMillis();
		List<String> activities = StudentRepository.getStudents()
		.parallelStream().peek(student -> System.out.println("Stream : " + student))
		.map(student -> student.getActivities()).peek(list -> System.out.println("MAP :" + list )) // Stream<<List<String>>
		.flatMap(list -> list.stream()).peek(activity -> System.out.println("FlatMap : " + activity))
		.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		System.out.println("\nParallel Time : " + (end-start) + "\n");
		return activities;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sequential List :" + seqStreamCase());
		 System.out.println("Parallel List :" + parallelStreamCase());
	}

}











