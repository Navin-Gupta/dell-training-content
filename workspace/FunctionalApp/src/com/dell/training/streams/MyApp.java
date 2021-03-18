package com.dell.training.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyApp {

	public static void main(String args[]) {
		List<String> names = new ArrayList<String>();
		
		names.add("First");
		names.add("Second");
		names.add("Third");
		names.add("Fourth");
		names.add("Fifth");
		
		// non-stream iteration
		names.forEach(System.out::println);
		names.forEach(System.out::println);
		
		System.out.println("\n\n");
		// stream way
		// names.stream().forEach(System.out::println);
		Stream<String> nameStream = names.stream();  // stream not started yet
		
		// will start when some action we call on it
		nameStream.forEach(System.out::println);
		// non-reusable
		nameStream.forEach(System.out::println);
		
	}
}
