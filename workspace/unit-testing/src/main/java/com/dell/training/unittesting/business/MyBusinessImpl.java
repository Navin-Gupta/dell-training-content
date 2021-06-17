package com.dell.training.unittesting.business;

import com.dell.training.unittesting.service.NumberDataService;

public class MyBusinessImpl {

	private NumberDataService numberDataService;
	
	public void setNumberDataService(NumberDataService dataService) {
		this.numberDataService = dataService;
	}
	public int calculateSum(int[]data) {
		int sum = 0;
		for(int value : data) {
			sum += value;
		}
		return sum;
	}
	
	public int calculateSumUsingService() {
		int sum = 0;
		int data[] = this.numberDataService.getDataFromDB();
		for(int value : data) {
			sum += value;
		}
		return sum;
	}
}
