package com.dell.training.streams;

import java.util.stream.IntStream;

public class ParallelStreamActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// external mutable object/service
		Calculator calculator = new Calculator();
		
		/*IntStream.range(1, 1001)
		.forEach(value -> calculator.add(value));
		
		System.out.println("Sequential Sum : " + calculator.getResult());*/
		
		IntStream.range(1, 1001).parallel()
		.forEach(value -> calculator.add(value));
		
		System.out.println("Parallel Sum : " + calculator.getResult());
	}

}
