package com.brycen.hrm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Department;
import com.brycen.hrm.repository.DepartmentRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAll() {
	    try {
	      List<Department> departments = new ArrayList<Department>();

	      departmentRepository.findAll().forEach(departments::add);

	      if (departments.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(departments, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	 @GetMapping("/departments/{id}")
	  public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id) {
	    Optional<Department> departmentData = departmentRepository.findById(id);

	    if (departmentData.isPresent()) {
	      return new ResponseEntity<>(departmentData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	@PostMapping("/departments")
	public ResponseEntity<?> createDepartment(@RequestBody Department department) {
		try {
			Department departments = departmentRepository
		          .save(new Department(department.getDepartmentName(), department.getDepartmentShort()));
		      
		      return new ResponseEntity<>(departments, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		    }
	}
	
	@PutMapping("/departments/{id}")
	  public ResponseEntity<Department> updateTutorial(@PathVariable("id") Integer id, @RequestBody Department department) {
	    Optional<Department> departmentData = departmentRepository.findById(id);

	    if (departmentData.isPresent()) {
	    	Department _department = departmentData.get();
	    	_department.setDepartmentName(department.getDepartmentName());
	    	_department.setDepartmentShort(department.getDepartmentShort());
	      return new ResponseEntity<>(departmentRepository.save(_department), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/departments/{id}")
	  public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Integer id) {
	    try {
	    	departmentRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
}
