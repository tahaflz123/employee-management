package com.management.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.management.entity.Department;
import com.management.entity.employee.Gender;

import lombok.Data;

@Data
public class EmployeeCreationRequest {
	
	private String name;
	
	private String surname;
	
	private String phoneNumber;
	
	private String email;
	
	private Gender gender;
	
	private Date birthdate;

}
