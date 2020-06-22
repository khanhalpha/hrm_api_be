package com.brycen.hrm.controller;

import java.util.List;
import java.util.Optional;

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
import com.brycen.hrm.model.RoleScreen;
import com.brycen.hrm.model.Screen;
import com.brycen.hrm.payload.request.RoleScreenRequest;
import com.brycen.hrm.payload.response.MessageResponse;
import com.brycen.hrm.payload.response.SkillTest;
import com.brycen.hrm.repository.RoleScreenReposiroty;
import com.brycen.hrm.repository.ScreenRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RoleScreenController {

    @Autowired
    RoleScreenReposiroty roleScreenRepository;
    
    @Autowired
    ScreenRepository screenRepository;
    
    
    @GetMapping("/rolescreen/{id}")
    public ResponseEntity<RoleScreen> getDepartmentById(@PathVariable("id") Long id) {
      Optional<RoleScreen> roleScreenData = roleScreenRepository.findById(id);

      if (roleScreenData.isPresent()) {
        return new ResponseEntity<>(roleScreenData.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    
    @PutMapping("/rolescreen/{id}")
    public ResponseEntity<?> updateRoleScreen(@PathVariable("id") long id, @RequestBody List<RoleScreenRequest> listRoleScreen)
    {  
        for(int i =0; i < listRoleScreen.size(); i++)
        {
            System.out.println(listRoleScreen.get(i).getRoleid());
            System.out.println(listRoleScreen.get(i).getScreenid());

            Optional<RoleScreen> roleScreenData = roleScreenRepository.findByRoleScreen(listRoleScreen.get(i).getScreenid(), listRoleScreen.get(i).getRoleid());
            if (roleScreenData.isPresent())
            {
                RoleScreen _roleScreen = roleScreenData.get();
                _roleScreen.setAccess(listRoleScreen.get(i).isAccess());
                roleScreenRepository.save(_roleScreen);
            }           
        }
        return ResponseEntity.ok(new MessageResponse("Update roleScreen successfully!"));
    }
}
