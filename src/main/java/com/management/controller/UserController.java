package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.dto.LoginRequest;
import com.management.dto.RegistrationRequest;
import com.management.entity.user.User;
import com.management.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User register(@RequestBody RegistrationRequest request) {
		return this.userService.register(request);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return this.userService.login(request);
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return this.userService.findAll();
	}
	

}
