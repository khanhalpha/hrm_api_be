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

import com.brycen.hrm.model.LevelSkill;
import com.brycen.hrm.repository.LvSkillRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LvSkillController {
	
	@Autowired
	LvSkillRepository lvSkillRepository;
	
	@GetMapping("/lvskills")
	public ResponseEntity<List<LevelSkill>> getAll() {
	    try {
	      List<LevelSkill> levelskills = new ArrayList<LevelSkill>();

	      lvSkillRepository.findAll().forEach(levelskills::add);

	      if (levelskills.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(levelskills, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	 @GetMapping("/lvskills/{id}")
	  public ResponseEntity<LevelSkill> getLevelSkill(@PathVariable("id") Long id) {
	    Optional<LevelSkill> levelSkillData = lvSkillRepository.findById(id);

	    if (levelSkillData.isPresent()) {
	      return new ResponseEntity<>(levelSkillData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	@PostMapping("/lvskills")
	public ResponseEntity<?> createSkill(@RequestBody LevelSkill levelSkill) {

		try {
			LevelSkill departments = lvSkillRepository
		          .save(new LevelSkill(levelSkill.getLevelname(), levelSkill.getLeveldescription()));
		      
		      return new ResponseEntity<>(departments, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		    }
	}
	
	@PutMapping("/lvskills/{id}")
	  public ResponseEntity<LevelSkill> updateSkill(@PathVariable("id") Long id, @RequestBody LevelSkill levelSkill) {
	    Optional<LevelSkill> levelSkillData = lvSkillRepository.findById(id);

	    if (levelSkillData.isPresent()) {
	    	LevelSkill _lvsSkill = levelSkillData.get();
	    	_lvsSkill.setLevelname(levelSkill.getLevelname());
	    	_lvsSkill.setLevelDescription(levelSkill.getLeveldescription());
	      return new ResponseEntity<>(lvSkillRepository.save(_lvsSkill), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/lvskills/{id}")
	  public ResponseEntity<HttpStatus> deleteSkill(@PathVariable("id") Long id) {
	    try {
	    	lvSkillRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
}
