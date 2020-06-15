package com.brycen.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brycen.hrm.model.Department;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Integer> {
	@Modifying
	@Transactional 
	@Query(value = "select * from departments where disable=0", nativeQuery = true)
	List<Department> findAllByDisable();
}
