package com.dell.training.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.dell.training.unittesting.service.NumberDataService;

// @SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MyBusinessImplTest {

	@InjectMocks
	MyBusinessImpl businessImpl;
	
	@Mock
	NumberDataService dataService;
	
	
	@Test
	public void test_calculateSumUsingService() {
		
		// Setup
		// mock the method
		when(this.dataService.getDataFromDB()).thenReturn(new int[] {1, 2, 3});
		
		
		// Invocation
		int actualResult = this.businessImpl.calculateSumUsingService();
		
		// Test
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void test_std_calculateSum() {
		// Setup
		MyBusinessImpl business = new MyBusinessImpl();
		
		// Invocation
		int actualResult = business.calculateSum(new int[] {1, 2, 3});
		
		// Test
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void test_empty_calculateSum() {
		// Setup
		MyBusinessImpl business = new MyBusinessImpl();
		
		// Invocation
		int actualResult = business.calculateSum(new int[] {});
		
		// Test
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
}
