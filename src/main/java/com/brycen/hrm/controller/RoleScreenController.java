package com.brycen.hrm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.RoleScreen;
import com.brycen.hrm.repository.RoleScreenReposiroty;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RoleScreenController {

    @Autowired
    RoleScreenReposiroty roleScreenRepository;
    
    @GetMapping("/rolescreen/{id}")
    public ResponseEntity<RoleScreen> getDepartmentById(@PathVariable("id") Long id) {
      Optional<RoleScreen> roleScreenData = roleScreenRepository.findById(id);

      if (roleScreenData.isPresent()) {
        return new ResponseEntity<>(roleScreenData.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
}
