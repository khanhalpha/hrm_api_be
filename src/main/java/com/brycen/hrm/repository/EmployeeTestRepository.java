package com.brycen.hrm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.brycen.hrm.model.Employee;

public interface EmployeeTestRepository  extends JpaRepository<Employee, Long>{

	
	
	@Query( value = "SELECT * FROM employees e where e.fullname like %:fullname" , nativeQuery = true)
	Page<Employee> findByNameContaining(@Param("fullname") String fullname, Pageable pageable);

	@Query(	value = "SELECT * FROM employees e "
			+ "LEFT JOIN employee_skill es "
			+ "ON e.employee_id = es.employee_id "
			+ "WHERE es.skill_id =:skillId" , 
			nativeQuery = true)
	Page<Employee> findBySkillContaining(@Param("skillId")Long skillId, Pageable pageable);
	
	@Query(	value = "SELECT * FROM employees e WHERE e.department_id =:departmentId" , 
			nativeQuery = true)
	Page<Employee> findByDepartmentContaining(@Param("departmentId")Long departmentId, Pageable pageable);
	
	@Query(	value = "SELECT * FROM employees e "
			+ "LEFT JOIN employee_skill es "
			+ "ON e.employee_id = es.employee_id "
			+ "WHERE es.skill_id =:skillId AND e.department_id =:departmentId" , 
			nativeQuery = true)
	Page<Employee> findBySkillDepartment(@Param("skillId")Long skillId, @Param("departmentId")Long departmentId, Pageable pageable);
	
	@Query(	value = "SELECT * FROM employees e "
			+ "LEFT JOIN employee_skill es "
			+ "ON e.employee_id = es.employee_id "
			+ "WHERE e.fullname like %:fullname and es.skill_id =:skillId" , 
			nativeQuery = true)
	Page<Employee> findByNameSkillContaining(@Param("fullname")String fullName, @Param("skillId")Long skillId, Pageable pageable);
	
	@Query(	value = "SELECT * FROM employees e WHERE e.fullname like %:fullname and e.department_id =:departmentId" , 
			nativeQuery = true)
	Page<Employee> findByNameDepartmentContaining(@Param("fullname")String fullName, @Param("departmentId")Long departmentId, Pageable pageable);
	
	@Query(	value = "SELECT * FROM employees e "
			+ "LEFT JOIN employee_skill es "
			+ "ON e.employee_id = es.employee_id "
			+ "WHERE e.fullname like %:fullname and e.department_id =:departmentId and es.skill_id =:skillId" , 
			nativeQuery = true)
	Page<Employee> findByNameSkillDepartmentContaining(@Param("fullname")String fullName, @Param("skillId")Long skillId, @Param("departmentId") Long departmentId, Pageable pageable);
}
