package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.brycen.hrm.model.EmployeeSkill;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {
	@Modifying
	@Transactional 
	@Query(value = "delete from employee_skill b where b.employee_id=:employeeId", nativeQuery = true)
	void deleteByEmployeeId(@Param("employeeId") Long employeeId);
}
