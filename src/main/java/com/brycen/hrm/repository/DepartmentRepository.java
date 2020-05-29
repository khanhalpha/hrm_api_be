package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.Department;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long> {

}
