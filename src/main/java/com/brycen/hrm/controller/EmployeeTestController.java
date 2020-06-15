package com.brycen.hrm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.payload.response.EmployeeReponse;
import com.brycen.hrm.repository.EmployeeTestRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EmployeeTestController {
	@Autowired
	EmployeeTestRepository employeeTestRepository;

	@Autowired
	 private EntityManager em;

//	@GetMapping("/employees/filter")
//	public Page<EmployeeReponse> getAllEmployeesPage(@RequestParam(required = false) Long skillId,
//			@RequestParam(required = false) Long departmentId, @RequestParam(defaultValue = "0") int page,
//			@RequestParam(defaultValue = "20") int size) {
//
//		Pageable paging = PageRequest.of(page, size);
//
//		Page<Employee> pageTuts;
//
//		if (skillId == 0 && departmentId == 0)
//			pageTuts = employeeTestRepository.findAll(paging);
//		else {
//			if (skillId != 0 && departmentId == 0) {
//				pageTuts = employeeTestRepository.findBySkillContaining(skillId, paging);
//			} else {
//				if (skillId == 0 && departmentId != 0) {
//					pageTuts = employeeTestRepository.findByDepartmentContaining(departmentId, paging);
//				} else {
//					pageTuts = employeeTestRepository.findBySkillDepartment(skillId, departmentId, paging);
//				}
//			}
//		}
//
//		List<EmployeeReponse> employees = pageTuts.stream().map(EmployeeReponse::new).collect(Collectors.toList());
//
//		return new PageImpl<>(employees, paging, pageTuts.getTotalElements());
//
//	}
	
	@GetMapping("/employees/filter")
	public Page<Employee> getAllEmployeesPage(
			@RequestParam(required = false) String fullname,
			@RequestParam(required = false, defaultValue = "0") Long skillId,
			@RequestParam(required = false, defaultValue = "0") Long departmentId, 
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int size) {
		boolean flag = false;
		Pageable paging = PageRequest.of(page, size);
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT * FROM employees e "+ System.lineSeparator());
		if(skillId != 0)
		{
			sqlQuery.append("LEFT JOIN employee_skill es "+ System.lineSeparator());
			sqlQuery.append("ON e.employee_id = es.employee_id "+ System.lineSeparator());
		}
		if(fullname!= null || skillId != 0 || departmentId != 0)
			sqlQuery.append("WHERE ");
		if(fullname != null)
		{
			sqlQuery.append("e.fullname like '%" + fullname + "' "+ System.lineSeparator());
			flag= true;
		}
		if(skillId != 0)
		{
			if(flag) sqlQuery.append(" AND ");
			sqlQuery.append("es.skill_id ="+ skillId + System.lineSeparator());
			flag= true;
		}
		if(departmentId != 0)
		{
			if(flag) sqlQuery.append(" AND ");
			sqlQuery.append("e.department_id =" + departmentId);
		}
		Query q =  em.createNativeQuery(sqlQuery.toString(), Employee.class);
		int totalElemt = q.getResultList().size();
		List<Employee> employees = q
				.setFirstResult(page*size)
				.setMaxResults(size)
				.getResultList();
//		System.out.print(sqlQuery.toString() + System.lineSeparator() + employees.size());
		try
		{
		    Thread.sleep(500);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		return new PageImpl<>(employees, paging, totalElemt);
	}
}
