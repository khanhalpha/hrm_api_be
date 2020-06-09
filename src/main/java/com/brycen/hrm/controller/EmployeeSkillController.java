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
import com.brycen.hrm.model.LevelSkill;
import com.brycen.hrm.model.Skill;
import com.brycen.hrm.payload.request.EmployeeRequest;
import com.brycen.hrm.payload.request.EmployeeSkillRequest;
import com.brycen.hrm.payload.response.MessageResponse;
import com.brycen.hrm.payload.response.SkillTest;
import com.brycen.hrm.repository.EmployeeRepository;
import com.brycen.hrm.repository.EmployeeSkillRepository;
import com.brycen.hrm.repository.LevelRepository;
import com.brycen.hrm.repository.SkillRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EmployeeSkillController {

	@Autowired
	EmployeeSkillRepository empSkillRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	SkillRepository skillRepository;
	
	@Autowired
	LevelRepository levelRepository;
	
	@RequestMapping(value = "/skill-employees/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	//@PutMapping("/skill-employees/{id}")
	public ResponseEntity<?> updateEmpSkill(@PathVariable("id") long id, @RequestBody List<SkillTest> list) {
		Optional<Employee> employeeData = employeeRepository.findById(id);
		if (employeeData.isPresent()) {
			empSkillRepository.deleteByEmployeeId(id);
			for ( int i = 0; i < list.size() ; i ++ )
			{
//				if (list.get(i).getEmpskill() == null || list.get(i).getEmpskill() != 0 )
//				{
//					
//				}
				Skill skill = skillRepository.findById(list.get(i).getSkill()).get();
				LevelSkill level = levelRepository.findById(list.get(i).getLevel()).get();
				EmployeeSkill empSKill = new EmployeeSkill(employeeData.get(),skill,level);
				empSkillRepository.save(empSKill);
//				if (list.get(i).getEmpskill() == null || list.get(i).getEmpskill() == 0 )
//				{
//					Skill skill = skillRepository.findById(list.get(i).getSkill()).get();
//					LevelSkill level = levelRepository.findById(list.get(i).getLevel()).get();
//					EmployeeSkill empSKill = new EmployeeSkill(employeeData.get(),skill,level);
//					empSkillRepository.save(empSKill);
//				}
//				else
//				{
//					Optional<EmployeeSkill> empSkillData = empSkillRepository.findById(list.get(i).getEmpskill());
//					Skill skill = skillRepository.findById(list.get(i).getSkill()).get();
//					LevelSkill level = levelRepository.findById(list.get(i).getLevel()).get();
//					EmployeeSkill empSKill = empSkillData.get();
//					empSKill.setskill(skill);
//					empSKill.setlevel(level);
//					empSkillRepository.save(empSKill);
//				}
			}
			return ResponseEntity.ok(new MessageResponse("Update successfully!"));
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	

}
