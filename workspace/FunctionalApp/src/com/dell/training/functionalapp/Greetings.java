package com.dell.training.functionalapp;

@FunctionalInterface
public interface Greetings {

	void sendGreetings(String message);
	// void test();
	
	default void test() {
		System.out.println("Inside test of Greetings");
	}
	
	static void sfun() {
		System.out.println("Inside static function of Greetings");
	}
}
