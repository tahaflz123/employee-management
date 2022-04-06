package com.management.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.management.dto.LoginRequest;
import com.management.dto.RegistrationRequest;
import com.management.entity.user.User;
import com.management.test.helper.CreateEntity;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UserControllerIT {

	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	/*@Test
	void register() {
		RegistrationRequest registrationRequest = CreateEntity.registrationRequest();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("CONTENT_TYPE", "application/json");
		HttpEntity<RegistrationRequest> requestEntity = new HttpEntity<RegistrationRequest>(registrationRequest, headers);
		ResponseEntity<User> user = this.restTemplate.exchange("http://localhost:8080/user/register", HttpMethod.POST, requestEntity, new ParameterizedTypeReference<User>() {});
		
		System.err.println(user.toString());
		System.err.println(user.getBody().toString());
		
		
		
		
	}
	@Test
	void login() {
		LoginRequest loginRequest = new LoginRequest();
		RegistrationRequest regReq = CreateEntity.registrationRequest();
		loginRequest.setEmail(regReq.getEmail());
		loginRequest.setPassword(regReq.getPassword());
		
		HttpHeaders header = new HttpHeaders();
		header.add("CONTENT_TYPE", "application/json");
		
		HttpEntity<LoginRequest> httpEntity = new HttpEntity<>(loginRequest, header);
		
		ResponseEntity<String> token = this.restTemplate.exchange("http://localhost:8080/user/login", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<String>() {});
		System.err.println(token.getBody().toString());
	}
	
	 */
	
	
}
