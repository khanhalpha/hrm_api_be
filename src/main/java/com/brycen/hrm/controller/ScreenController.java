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

import com.brycen.hrm.model.Screen;
import com.brycen.hrm.repository.ScreenRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ScreenController {

    @Autowired
    ScreenRepository screenRepository;
    
    @GetMapping("/screen/{id}")
    public ResponseEntity<Screen> getDepartmentById(@PathVariable("id") Long id) {
      Optional<Screen> screenData = screenRepository.findById(id);

      if (screenData.isPresent()) {
        return new ResponseEntity<>(screenData.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
}
