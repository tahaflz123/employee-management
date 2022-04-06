package com.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long>{

	List<Salary> findAllById(Long employeeId);

	@Query("SELECT s FROM Salary s where s.employee.id=:id")
	List<Salary> findAllByEmployeeId(Long id);

}
