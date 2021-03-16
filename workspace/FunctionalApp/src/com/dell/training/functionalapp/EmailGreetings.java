package com.dell.training.functionalapp;

public class EmailGreetings implements Greetings {

	@Override
	public void sendGreetings(String message) {
		System.out.println("Message Conveyed over email : " + message);

	}

}
