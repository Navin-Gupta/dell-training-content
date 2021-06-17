package com.dell.training.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dell.training.unittesting.model.Student;
import com.dell.training.unittesting.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StudentService service;
	
	@Test
	public void test_getByIdEndpointBDD() throws Exception {
		// Setup
		Student student = new Student(1, "First", "first@mail.com");
		final int count[] = new int[1];
		// when(this.service.getById(1)).thenReturn(student);
		when(this.service.getById(1)).then(new Answer<Student>() {

			@Override
			public Student answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return student;
			}
			
		});
		
		// build the mvc request
		RequestBuilder builder = MockMvcRequestBuilders.get("/student/byid/1")
							.contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON);
							// .content(<json string>);
		
		
		// Call
		MvcResult result = this.mockMvc.perform(builder).andReturn();
		
		
		// Test
		assertEquals(1, count[0]);
	}
	
	
	@Test
	public void test_getByIdEndpoint() throws Exception {
		// Setup
		Student student = new Student(1, "First", "first@mail.com");
		when(this.service.getById(1)).thenReturn(student);
		
		// build the mvc request
		RequestBuilder builder = MockMvcRequestBuilders.get("/student/byid/1")
							.contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON);
							// .content(<json string>);
		
		
		// Call
		MvcResult result = this.mockMvc.perform(builder).andReturn();
		String actualResult = result.getResponse().getContentAsString(); // json string
		String expectedResult = asJsonString(student);
		
		// Test
		assertEquals(expectedResult, actualResult);
	}
	
	// method to convert a pojo to json string
	public static String asJsonString(Object object) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(object);
		return jsonString;
	}
	
}
