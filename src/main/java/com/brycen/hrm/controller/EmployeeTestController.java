package com.brycen.hrm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

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
	//private EntityManager em;
	
	@GetMapping("/employees/filter")
	  public Page<EmployeeReponse> getAllEmployeesPage(
	      @RequestParam(required = false) Long skillId,
	      @RequestParam(required = false) Long departmentId,
	      @RequestParam(defaultValue = "0") int page,
	      @RequestParam(defaultValue = "20") int size) {

//	    try {

	      Pageable paging = PageRequest.of(page, size);

	      Page<Employee> pageTuts;
	      
	      if (skillId == 0 && departmentId == 0)
	        pageTuts = employeeTestRepository.findAll(paging);
	      else
	      {    	  
	    	  if( skillId != 0 && departmentId == 0)
	    	  {
	    		  pageTuts = employeeTestRepository.findBySkillContaining(skillId, paging);
	    	  }
	    	  else
	    	  {
	    		  if(skillId == 0 && departmentId != 0)
	    		  {
	    			  pageTuts = employeeTestRepository.findByDepartmentContaining(departmentId, paging);
	    		  }
	    		  else
	    		  {	    			  
	    			pageTuts = employeeTestRepository.findBySkillDepartment(skillId, departmentId, paging);
	    		  }
	    	  }	    	  
	      }
	      
			List<EmployeeReponse> employees = pageTuts.stream().map(EmployeeReponse::new).collect(Collectors.toList());

			return new PageImpl<>(employees, paging, pageTuts.getTotalElements());
			
//	      employees = pageTuts.getContent();
//
//	      if (employees.isEmpty()) {
//	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	      }
//
//	      Map<String, Object> response = new HashMap<>();
//	      response.put("employees", employees);
//	      response.put("currentPage", pageTuts.getNumber());
//	      response.put("totalItems", pageTuts.getTotalElements());
//	      response.put("totalPages", pageTuts.getTotalPages());
//
//	      return new ResponseEntity<>(response, HttpStatus.OK);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
	  }
}
