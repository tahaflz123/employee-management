package com.management.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.management.dto.EmployeeCreationRequest;
import com.management.entity.Department;
import com.management.entity.employee.Employee;
import com.management.repository.EmployeeRepository;
import com.management.service.DepartmentService;
import com.management.service.EmployeeService;
import com.management.test.helper.CreateEntity;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Mock
	private DepartmentService departmentService;
	
	@Mock
	private EmployeeRepository employeeRepository;

	
	@Test
	void createEmployeeTest() {
		EmployeeCreationRequest request = CreateEntity.employeeCreationRequest();
		Employee employee = CreateEntity.employee();
		
		when(this.employeeRepository.save(any(Employee.class))).thenReturn(employee);
		
		Employee response = this.employeeService.createEmployee(request);
		
		assertThat(response).isNotNull();
		assertThat(employee).isEqualTo(response);
		assertEquals(request.getName(),response.getName());
		assertEquals(request.getSurname(), response.getSurname());
		assertEquals(request.getPhoneNumber(), response.getPhoneNumber());
		assertEquals(request.getEmail(),response.getEmail());
		assertEquals(request.getGender(), response.getGender());
		assertEquals(request.getBirthdate(), response.getBirthdate());
	}
	
	@Test
	void setEmployeeDepartmentTest() {
		Employee employee = CreateEntity.employee();
		Department department = CreateEntity.department();
		
		when(this.employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
		when(this.departmentService.findDepartmentById(department.getId())).thenReturn(department);
		when(this.employeeRepository.save(any(Employee.class))).thenReturn(employee);
		
		Employee response = this.employeeService.setEmployeeDepartment(employee.getId(), department.getId());
		
		assertThat(response).isNotNull();
		assertThat(response).isEqualTo(employee);
		assertThat(response.getDepartment()).isEqualTo(employee.getDepartment());
		assertThat(response.getDepartment()).isEqualTo(department);
	}
	
}
