package com.dell.training.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParalleComplex {

	static int seqSum(List<Integer> numbers) {
		long start = System.currentTimeMillis();
		int total = numbers.stream() // value from stream 'y' | 'x' initial & accumulative
				.reduce(0,(x,y)-> x+y);
		long end = System.currentTimeMillis();
		System.out.println("Sequential Time : " + (end-start));
		return total;
	}
	
	
	static int parallelSum(List<Integer> numbers) {
		long start = System.currentTimeMillis();
		int total = numbers.parallelStream() // value from stream 'y' | 'x' initial & accumulative
				.reduce(0,(x,y)-> x+y);
		long end = System.currentTimeMillis();
		System.out.println("Parallel Time : " + (end-start));
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a collection of number from 1-1000
		List<Integer> numbers = IntStream.range(1, 1001) // Stream<int>
								.boxed() // Stream<Integer>
								.collect(Collectors.toList());
		
		System.out.println("Sequential Sum : " + seqSum(numbers));
		System.out.println("Parallel Sum : " + parallelSum(numbers));
	}

}










