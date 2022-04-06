package com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.entity.Department;
import com.management.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department createDepartment(String name) {
		Department department = new Department();
		department.setName(name);
		return this.departmentRepository.save(department);
	}
	
	public List<Department> findAll() {
		return this.departmentRepository.findAll();
	}
	
	public Department findDepartmentById(Long id) {
		return this.departmentRepository.findById(id).get();
	}
	
	public List<Department> findDepartmentsByName(String name) {
		return this.departmentRepository.findAllByNameLike(name);
	}
	
	
}
