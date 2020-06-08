package com.brycen.hrm.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Department;
import com.brycen.hrm.model.Employee;
import com.brycen.hrm.payload.request.EmployeeRequest;
import com.brycen.hrm.payload.response.EmployeeReponse;
import com.brycen.hrm.repository.DepartmentRepository;
import com.brycen.hrm.repository.EmployeeRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

//	@GetMapping("/employees")
//	public ResponseEntity<List<Employee>> getAll() {
//		try {
//			List<Employee> employees = new ArrayList<Employee>();
//			employeeRepository.findAll().forEach(employees::add);
//			if (employees.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(employees, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

//	@GetMapping("/employees")
//	public ResponseEntity<List<Employee>> getAll(@RequestParam(name = "page", defaultValue = "0") int page,
//			@RequestParam(name = "size", defaultValue = "5") int size) {
//		PageRequest pageRequest = PageRequest.of(page, size);
//		Page<Employee> pageResult = employeeRepository.findAll(pageRequest);
//
//		if (pageResult.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(pageResult.getContent(), HttpStatus.OK);
//
//	}

	@GetMapping("/employees")
	public Page<EmployeeReponse> getAll(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Employee> pageResult = employeeRepository.findAll(pageRequest);

		List<EmployeeReponse> employees = pageResult.stream().map(EmployeeReponse::new).collect(Collectors.toList());
		try
		{
		    Thread.sleep(500);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		return new PageImpl<>(employees, pageRequest, pageResult.getTotalElements());

	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getDepartmentById(@PathVariable("id") long id) {
		Optional<Employee> employeetData = employeeRepository.findById(id);

		if (employeetData.isPresent()) {
			return new ResponseEntity<>(employeetData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/employees")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest) {

		try {
			Department department = departmentRepository.findById(employeeRequest.getDepartmentid()).get();
			System.out.print(department.getDepartmentName());
			Employee emp = new Employee(employeeRequest.getFullname(), employeeRequest.getBirthday(),
					employeeRequest.getGender(), department);
			Employee employees = employeeRepository.save(emp);

			return new ResponseEntity<>(employees, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateTutorial(@PathVariable("id") long id, @RequestBody Employee employee) {
		Optional<Employee> employeeData = employeeRepository.findById(id);

		if (employeeData.isPresent()) {
			Employee _employee = employeeData.get();
			_employee.setFullname(employee.getFullname());
			_employee.setBirthDay(employee.getBirthday());
			_employee.setGender(employee.getGender());
			_employee.setDepartment(employee.getDepartment());
			return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") long id) {
		try {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
