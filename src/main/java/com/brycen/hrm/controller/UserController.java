package com.brycen.hrm.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Department;
import com.brycen.hrm.model.Role;
import com.brycen.hrm.model.User;
import com.brycen.hrm.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAll() {
	    try {
	      List<User> users = new ArrayList<User>();

	      userRepository.findAll().forEach(users::add);

	      if (users.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	 @GetMapping("/users/{id}")
	  public ResponseEntity<User> getSkill(@PathVariable("id") Long id) {
	    Optional<User> userData = userRepository.findById(id);

	    if (userData.isPresent()) {
	      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
//	 @PutMapping("/users/{id}")
//	 public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user)
//	 {
//	     Optional<User> userData = userRepository.findById(id);
//	     if(userData.isPresent())
//	     {
//	         User _user = userData.get();
//	         Set<String> strRoles = user.getRole();
//	         Set<Role> roles = new HashSet<>();
//	         _user.setRoles(roles);
//	     }
//	 }
}
