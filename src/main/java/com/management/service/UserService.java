package com.management.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.management.config.JWTService;
import com.management.dto.LoginRequest;
import com.management.dto.RegistrationRequest;
import com.management.entity.user.User;
import com.management.entity.user.UserRole;
import com.management.exception.AuthenticationException;
import com.management.repository.UserRepository;

@Service
public class UserService {

	
	
	private BCryptPasswordEncoder passwordEncoder;
	private UserRepository userRepository;
	private JWTService jwtService;
	
	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JWTService jwtService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}
	
	public User register(RegistrationRequest request) {
		boolean existsByEmail = this.userRepository.existsByEmail(request.getEmail());
		if(existsByEmail) {
			throw new AuthenticationException("Email is valid...");
		}
		
		User user = new User();
		user.setName(request.getName());
		user.setSurname(request.getSurname());
		user.setEmail(request.getEmail());
		user.setCreatedDate(new Date());
		user.setPassword(this.passwordEncoder.encode(request.getPassword()));
		user.setRole(UserRole.USER);
		return this.userRepository.save(user);
	}
	
	
	public String login(LoginRequest request) {
		User user = this.userRepository.findByEmail(request.getEmail());
		boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());
		if(user == null || !matches) {
			throw new AuthenticationException("Email and password isn't match...");
		}
		String token = this.jwtService.createToken(request.getEmail());
		return token;
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public User getLoggedInUser() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return this.userRepository.findByEmail(email);
	}

	public User findUserById(Long id) {
		return this.userRepository.findById(id).get();
	}

	public User save(User user) {
		return this.userRepository.save(user);
	}

}
