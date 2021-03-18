package com.dell.training.streams;

public class Calculator {
	private int result;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	// perform addition
	public void add(int input) {
		result += input;
	}
}
// 1 2 3
