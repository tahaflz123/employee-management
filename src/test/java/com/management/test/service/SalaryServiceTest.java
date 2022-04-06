package com.management.test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.Date;

import com.management.entity.Salary;
import com.management.entity.employee.Employee;
import com.management.entity.employee.Gender;
import com.management.repository.SalaryRepository;
import com.management.service.EmployeeService;
import com.management.service.SalaryService;

@ExtendWith(MockitoExtension.class)
public class SalaryServiceTest {

	@InjectMocks
	private SalaryService salaryService;
	
	@Mock
	private EmployeeService employeeService;
	
	@Mock
	private SalaryRepository salaryRepository;
	
	
	@Test
	void paySalaryMethodTest() {
		Employee employee = new Employee();
		employee.setBirthdate(new Date());
		employee.setEmail("exapmle@mail.com");
		employee.setName("taha");
		employee.setSurname("filiz");
		employee.setGender(Gender.M);
		employee.setId(100L);
		employee.setPhoneNumber("00000");
		
		Salary salary = new Salary();
		salary.setAmount(2L);
		salary.setId(1L);
		salary.setFromDate(new Date());
		salary.setToDate(new Date());
		salary.setEmployee(employee);
		
		when(this.employeeService.findEmployeeById(employee.getId())).thenReturn(employee);
		
		when(this.salaryRepository.save(any(Salary.class))).thenReturn(salary);
		
		Salary response = this.salaryService.paySalary(employee.getId(), salary.getAmount());

		assertThat(response).isNotNull();
		assertThat(salary.getEmployee()).isEqualTo(response.getEmployee());
		assertThat(salary).isEqualTo(response);
	}
	
	
	
}
