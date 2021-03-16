package com.dell.training.functionalapp;

public class SmsGreetings implements Greetings {

	@Override
	public void sendGreetings(String message) {
		System.out.println("Message Conveyed over SMS : " + message);

	}

}