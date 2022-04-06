package com.management.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.entity.Department;
import com.management.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping("/create")
	public Department createDepartment(@PathParam("name") String name) {
		return this.departmentService.createDepartment(name);
	}
	
	@GetMapping
	public Department findDepartmentById(@PathParam("id") Long id) {
		return this.departmentService.findDepartmentById(id);
	}
	
	@GetMapping("/departments")
	public List<Department> findDepartmentsByName(@PathParam("name") String name){
		return this.departmentService.findDepartmentsByName(name);
	}
	
	@GetMapping("/all")
	public List<Department> findAll(){
		return this.departmentService.findAll();
	}
	
	
}
