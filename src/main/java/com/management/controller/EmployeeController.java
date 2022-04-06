package com.management.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.dto.EmployeeCreationRequest;
import com.management.entity.employee.Employee;
import com.management.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody EmployeeCreationRequest request) {
		return this.employeeService.createEmployee(request);
	}
	
	@GetMapping
	public Employee findEmployeeById(@PathParam("id") Long id) {
		return this.employeeService.findEmployeeById(id);
	}
	
	@GetMapping("/name")
	public List<Employee> findEmployeesByName(@PathParam("q") String q){
		return this.employeeService.findByNameLike(q);
	}
	
	@GetMapping("/surname")
	public List<Employee> findEmployeesBySurname(@PathParam("q") String q){
		return this.employeeService.findByNameLike(q);
	}
	
	@GetMapping("/all")
	public List<Employee> findAllByQuitFalse() {
		return this.employeeService.findAllByQuitFalse();
	}
	
	@GetMapping("/department/all")
	public List<Employee> findAllByDepartment(@PathParam("department_id") Long department_id){
		return this.employeeService.departmentEmployees(department_id);
	}
	
	@PutMapping("/set/department")
	public Employee setEmployeeDepartment(@PathParam("employee_id") Long employee_id, @PathParam("department_id") Long department_id) {
		return this.employeeService.setEmployeeDepartment(employee_id, department_id);
	}
	
	@GetMapping("/old/all")
	public List<Employee> findAll(){
		return this.employeeService.findAll();
	}
	
	@DeleteMapping("/delete")
	public Boolean deleteEmployeeById(@PathParam("id") Long id) {
		return this.employeeService.deleteEmployeeById(id);
	}
	
}
