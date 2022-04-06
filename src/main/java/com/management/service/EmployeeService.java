package com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dto.EmployeeCreationRequest;
import com.management.entity.Department;
import com.management.entity.employee.Employee;
import com.management.exception.AuthenticationException;
import com.management.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	private DepartmentService departmentService;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository, DepartmentService departmentService) {
		this.employeeRepository = employeeRepository;
		this.departmentService = departmentService;
	}

	public Employee createEmployee(EmployeeCreationRequest request) {
		Employee employee = new Employee();
		employee.setName(request.getName());
		employee.setSurname(request.getSurname());
		employee.setEmail(request.getEmail());
		employee.setPhoneNumber(request.getPhoneNumber());
		employee.setGender(request.getGender());
		employee.setQuit(false);
		employee.setBirthdate(request.getBirthdate());
		return this.employeeRepository.save(employee);
	}
	
	public List<Employee> findAllByQuitFalse(){
		return this.employeeRepository.findAllByQuitFalse();
	}
	
	public List<Employee> findAll(){
		return this.employeeRepository.findAll();
	}
	
	public Employee findEmployeeById(Long id){
		return this.employeeRepository.findById(id).get();
	}
	
	public List<Employee> findBySurnameLike(String surname){
		return this.employeeRepository.findAll();
	}
	
	public List<Employee> findByNameLike(String name){
		return this.employeeRepository.findByNameLike(name);
	}
	
	public List<Employee> departmentEmployees(Long id){
		Department department = this.departmentService.findDepartmentById(id);
		if(department == null) {
			throw new AuthenticationException("department is null");
		}
		return this.employeeRepository.findAllByDepartmentId(id);
	}
	
	public Employee setEmployeeDepartment(Long employeeId, Long departmentId) {
		Employee employee = this.employeeRepository.findById(employeeId).get();
		Department department = this.departmentService.findDepartmentById(departmentId);
		employee.setDepartment(department);
		return this.employeeRepository.save(employee);
	}
	
	public Boolean deleteEmployeeById(Long id) {
		Employee employee = new Employee();
		employee.setQuit(true);
		this.employeeRepository.save(employee);
		return true;
	}
	
}
