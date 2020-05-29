package com.brycen.hrm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Role;
import com.brycen.hrm.repository.RoleRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class RoleController {
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/rolers")
	public ResponseEntity<List<Role>> getAllTutorials() {
	    try {
	      List<Role> roles = new ArrayList<Role>();

	      roleRepository.findAll().forEach(roles::add);

	      if (roles.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(roles, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
