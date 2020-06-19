package com.brycen.hrm.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.model.Screen;
import com.brycen.hrm.repository.ScreenRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ScreenController {

    @Autowired
    ScreenRepository screenRepository;
    
    @Autowired
    private EntityManager em;
   
//    @GetMapping("/screens/{id}")
//    public ResponseEntity<Screen> getDepartmentById(@PathVariable("id") Long id) {
//      Optional<Screen> screenData = screenRepository.findById(id);
//
//      if (screenData.isPresent()) {
//        return new ResponseEntity<>(screenData.get(), HttpStatus.OK);
//      } else {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//      }
//    }
    
    @GetMapping("/screens/{id}")
    public List<ScreenRepository> getScrrenById(@PathVariable("id") Long id) {
      StringBuilder sqlQuery = new StringBuilder();
      sqlQuery.append("SELECT rs.rolescreen_id, rs.role_id, rs.screen_id, rs.access, s.screen_name, s.screen_url" + System.lineSeparator());
      sqlQuery.append("FROM hrm_test.role_screen rs" + System.lineSeparator());
      sqlQuery.append("left join hrm_test.screens s" + System.lineSeparator());
      sqlQuery.append("ON rs.screen_id = s.screen_id" + System.lineSeparator());
      sqlQuery.append("where rs.screen_id = " + id + System.lineSeparator());
      sqlQuery.append("order by rs.role_id" + System.lineSeparator());
      Query q = em.createNativeQuery(sqlQuery.toString());
      List<ScreenRepository> screens = q.getResultList();
      
      return screens;
    }
}
