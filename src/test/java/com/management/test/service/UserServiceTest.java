package com.management.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.management.config.JWTService;
import com.management.dto.LoginRequest;
import com.management.dto.RegistrationRequest;
import com.management.entity.user.User;
import com.management.entity.user.UserRole;
import com.management.repository.UserRepository;
import com.management.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private BCryptPasswordEncoder passwordEncoder;
	
	@Mock
	private JWTService jwtService;
	
	@Test
	void whenRegisterThenReturnRegisteredUser() {
		RegistrationRequest request = new RegistrationRequest();
		request.setName("taha");
		request.setSurname("filiz");
		request.setEmail("taha@mail.com");
		request.setPassword("12345");
		
		User user = new User();
		user.setName(request.getName());
		user.setSurname(request.getSurname());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		when(this.userRepository.existsByEmail(anyString())).thenReturn(false);
		when(this.userRepository.save(any(User.class))).thenReturn(user);
		
		User response = this.userService.register(request);
		
		assertThat(response).isNotNull();
		assertThat(response).isEqualTo(user);
		assertEquals(user.getName(), response.getName());
		assertEquals(user.getSurname(), response.getSurname());
		assertEquals(user.getEmail(),response.getEmail());
		assertEquals(user.getPassword(), response.getPassword());
	}
	
	@Test
	void loginMethodTest() {
		LoginRequest request = new LoginRequest();
		request.setEmail("example@mail.com");
		request.setPassword("12345");
		
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setCreatedDate(new Date());
		user.setName("wolf");
		user.setSurname("larsen");
		user.setRole(UserRole.USER);		
		
		when(this.userRepository.findByEmail(user.getEmail())).thenReturn(user);
		when(this.passwordEncoder.matches(request.getPassword(), user.getPassword())).thenReturn(true);
		when(this.jwtService.createToken(user.getEmail())).thenReturn("jwt-token");
		
		String token = this.userService.login(request);
		assertThat(token).isNotNull();
	}
}
