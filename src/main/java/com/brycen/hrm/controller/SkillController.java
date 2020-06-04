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

import com.brycen.hrm.model.Skill;
import com.brycen.hrm.repository.SkillRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SkillController {

	@Autowired
	SkillRepository skillRepository;
	
	@GetMapping("/skills")
	public ResponseEntity<List<Skill>> getAll() {
	    try {
	      List<Skill> skills = new ArrayList<Skill>();

	      skillRepository.findAll().forEach(skills::add);

	      if (skills.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(skills, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	 @GetMapping("/skills/{id}")
	  public ResponseEntity<Skill> getSkill(@PathVariable("id") Long id) {
	    Optional<Skill> skillData = skillRepository.findById(id);

	    if (skillData.isPresent()) {
	      return new ResponseEntity<>(skillData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	@PostMapping("/skills")
	public ResponseEntity<?> createSkill(@RequestBody Skill skill) {

		try {
			Skill skills = skillRepository
			          .save(new Skill(skill.getSkillname(), skill.getSkilldescription()));
		      
		      return new ResponseEntity<>(skills, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		    }
	}
	
	@PutMapping("/skills/{id}")
	  public ResponseEntity<Skill> updateSkill(@PathVariable("id") Long id, @RequestBody Skill skill) {
	    Optional<Skill> skillData = skillRepository.findById(id);

	    if (skillData.isPresent()) {
	    	Skill _skill = skillData.get();
	    	_skill.setSkillname(skill.getSkillname());
	    	_skill.setSkilldescription(skill.getSkilldescription());
	      return new ResponseEntity<>(skillRepository.save(_skill), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/skills/{id}")
	  public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Long id) {
	    try {
	    	skillRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
}
