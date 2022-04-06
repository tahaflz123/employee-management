package com.management.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.entity.Salary;
import com.management.entity.employee.Employee;
import com.management.repository.SalaryRepository;

@Service
public class SalaryService {
	
	private SalaryRepository salaryRepository;
	private EmployeeService employeeService;
	
	@Autowired
	public SalaryService(SalaryRepository  salaryRepository, EmployeeService employeeService) {
		this.employeeService = employeeService;
		this.salaryRepository = salaryRepository;
	}
	
	
	public Salary paySalary(Long employeeId ,Long count) {
		Employee employee = this.employeeService.findEmployeeById(employeeId);
		if(employee == null) {
			throw new RuntimeException("employee is not found");
		}
		Salary salary = new Salary();
		Date date = new Date();
		salary.setEmployee(employee);
		salary.setAmount(count);
		salary.setFromDate(date);
		salary.setToDate(new Date(date.getTime() + (30 * 24 * 60 * 60 * 1000)));
		return this.salaryRepository.save(salary);
	}
	
	public List<Salary> findAll(){
		return this.salaryRepository.findAll();
	}
	
	public List<Salary> findAllByEmployee(Long employeeId){
		return this.salaryRepository.findAllByEmployeeId(employeeId);
	}

}
