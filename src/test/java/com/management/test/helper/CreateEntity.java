package com.management.test.helper;

import java.util.Date;

import com.management.dto.EmployeeCreationRequest;
import com.management.dto.RegistrationRequest;
import com.management.entity.Department;
import com.management.entity.employee.Employee;
import com.management.entity.employee.Gender;

public class CreateEntity {
	
	public static Long employee_id = 500L;
	public static String employee_name = "taha";
	public static String employee_surname = "filiz";
	public static String employee_email = "example@mail.com";
	public static String employee_phoneNumber = "000000";
	public static Gender employee_gender = Gender.M;
	public static Date employee_birthdate = new Date();
	
	public static String user_name = "wolf";
	public static String user_surname = "larsen";
	public static String user_email = "example@mail.com";
	public static String user_password = "123456";

	public static Employee employee() {
		Employee employee = new Employee();
		employee.setId(employee_id);
		employee.setName(employee_name);
		employee.setSurname(employee_surname);
		employee.setBirthdate(employee_birthdate);
		employee.setEmail(employee_email);
		employee.setPhoneNumber(employee_phoneNumber);
		employee.setGender(employee_gender);
		return employee;
	}
	
	public static EmployeeCreationRequest employeeCreationRequest() {
		EmployeeCreationRequest request = new EmployeeCreationRequest();
		request.setName(employee_name);
		request.setSurname(employee_surname);
		request.setBirthdate(employee_birthdate);
		request.setEmail(employee_email);
		request.setPhoneNumber(employee_phoneNumber);
		request.setGender(employee_gender);
		return request;
	}
	
	public static Department department() {
		Department department = new Department();
		department.setId(1L);
		department.setName("it");
		return department;
	}
	
	public static RegistrationRequest registrationRequest() {
		RegistrationRequest request = new RegistrationRequest();
		request.setEmail(user_email);
		request.setPassword(user_password);
		request.setSurname(user_surname);
		request.setName(user_name);
		return request;
	}

}
