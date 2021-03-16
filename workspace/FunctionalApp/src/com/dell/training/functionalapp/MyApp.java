package com.dell.training.functionalapp;



class GreetingBase{
	
	// tightly coupled code
	/*public void conveyGreeting(String message) {
		System.out.println(message); // on console
	}*/
	// add one more method for email : 
	
	// loosly coupled
	/*public void conveyGreeting(String message, <where to convey>) {
		System.out.println(message); // on console
	}*/
	// inject the greeting impl
	public void conveyGreeting(String message, Greetings greetings) {
		greetings.sendGreetings(message);
	}
	
}

public class MyApp {
	
	public static void staticMethod(String str) {
		System.out.println("Static method : " + str);
	}
	
	public  void instanceMethod(String str) {
		System.out.println("Instance method : " + str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreetingBase app = new GreetingBase();
		// app.conveyGreeting("Hello All");
		Greetings emailGreetings = new EmailGreetings();
		Greetings smsGreetings = new SmsGreetings();
		
		app.conveyGreeting("Hello All", emailGreetings);
		app.conveyGreeting("Hello All", smsGreetings);
		
		app.conveyGreeting("Hello All", new Greetings() {
			
			@Override
			public void sendGreetings(String message) {
				System.out.println("Message conveyed over network :" + message);
				
			}
		});
		
		// directly inject functionality
		/* FunctionalType variable = void sendGreetings(String message) {
							System.out.println("Message conveyed on twitter :" + message)
			}*/
		
		// enhanced the nature of interface ~ Functional type
		/*Greetings twitterGreetings = void sendGreetings(String message) {
			System.out.println("Message conveyed on twitter :" + message)
		}*/
		// Lambda Expression : compact/terse of writing a function (anonymous function)
		Greetings twitterGreetings = (message) -> System.out.println("Message conveyed on twitter :" + message);
						
		// app.conveyGreeting("Hello All", twitterGreetings);
		app.conveyGreeting("Hello All", (message) -> System.out.println("Message conveyed on twitter :" + message));
		
		
		// Method Reference
		Greetings staticRef = MyApp :: staticMethod;
		app.conveyGreeting("Hello All", MyApp :: staticMethod);
		app.conveyGreeting("Hello All", new MyApp() :: instanceMethod);
		// any that has return type of void and single argument of type string
		app.conveyGreeting("Hello All", System.out::println);
		
	}

}

















