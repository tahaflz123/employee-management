package com.management.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.management.dto.EmployeeCreationRequest;
import com.management.entity.employee.Employee;
import com.management.test.helper.CreateEntity;
import com.management.test.helper.TokenHelper;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class EmployeeControllerIT {
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void createEmployee() {
		EmployeeCreationRequest employeeRequest = CreateEntity.employeeCreationRequest();
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content_Type", "application/json");
		header.add("Authorization", "Bearer " + TokenHelper.user_token);
		
		HttpEntity<EmployeeCreationRequest> httpEntity = new HttpEntity<>(employeeRequest,header);
		
		ResponseEntity<Employee> response = this.restTemplate.exchange("http://localhost:8080/employee/create", HttpMethod.POST, httpEntity, Employee.class);
		
		Employee employee = response.getBody();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(employee).isNotNull();
		assertEquals(employee.getName(), employeeRequest.getName());
		assertEquals(employee.getSurname(), employeeRequest.getSurname());
		assertEquals(employee.getBirthdate(), employeeRequest.getBirthdate());
		assertEquals(employee.getGender(), employeeRequest.getGender());
		assertEquals(employee.getPhoneNumber(), employeeRequest.getPhoneNumber());		
	}
}
