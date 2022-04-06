package com.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.entity.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findAllByQuitFalse();

	List<Employee> findByNameLike(String name);

	List<Employee> findAllByDepartmentId(Long id);

}
