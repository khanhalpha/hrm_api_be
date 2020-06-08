package com.brycen.hrm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Department;
import com.brycen.hrm.model.Employee;
import com.brycen.hrm.model.EmployeeSkill;
import com.brycen.hrm.payload.request.EmployeeRequest;
import com.brycen.hrm.payload.request.EmployeeSkillRequest;
import com.brycen.hrm.payload.response.SkillTest;
import com.brycen.hrm.repository.EmployeeRepository;
import com.brycen.hrm.repository.EmployeeSkillRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EmployeeSkillController {

	@Autowired
	EmployeeSkillRepository empSkillRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
//	@PostMapping("/employees")
//	public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
//
//		try {
//			Department department = departmentRepository.findById(employeeRequest.getDepartmentid()).get();
//			System.out.print(department.getDepartmentName());
//			Employee emp = new Employee(employeeRequest.getFullname(), employeeRequest.getBirthday(),
//					employeeRequest.getGender(), department);
//			Employee employees = employeeRepository.save(emp);
//
//			return new ResponseEntity<>(employees, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
	@RequestMapping(value = "/skill-employees/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	//@PutMapping("/skill-employees/{id}")
	public ResponseEntity<EmployeeSkill> updateEmpSkill(@PathVariable("id") long id, @RequestBody List<SkillTest> list) {
		for ( int i = 0; i < list.size() ; i ++ )
		{
			
		}
		Optional<EmployeeSkill> employeeData = empSkillRepository.findById(id);
		//employeeData.get().g
		if (employeeData.isPresent()) {
//			EmployeeSkill _employeeSkill = employeeData.get();
//			_employee.setFullname(employee.getFullname());
			return new ResponseEntity<>(null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
