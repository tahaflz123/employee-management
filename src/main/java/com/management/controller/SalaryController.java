package com.management.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.entity.Salary;
import com.management.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {

	
	@Autowired
	private SalaryService salaryService;
	
	@PostMapping("/create")
	public Salary paySalary(@PathParam("id, count") Long id, Long count) {
		return this.salaryService.paySalary(id, count);
	}
	
	@GetMapping("/all")
	public List<Salary> findAll(){
		return this.salaryService.findAll();
	}
	
	@GetMapping("/user")
	public List<Salary> findAllByUserId(@PathParam("id") Long id){
		return this.salaryService.findAllByEmployee(id);
	}
	
	
}
