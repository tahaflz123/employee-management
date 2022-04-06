package com.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


	@Query("SELECT c FROM Department c WHERE lower (c.name) like lower(concat('%', :name ,'%'))")
	List<Department> findAllByNameLike(String name);

}
