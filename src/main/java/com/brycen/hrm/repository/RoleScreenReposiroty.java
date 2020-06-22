package com.brycen.hrm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brycen.hrm.model.RoleScreen;
import com.brycen.hrm.model.Screen;
import com.brycen.hrm.model.User;

public interface RoleScreenReposiroty extends JpaRepository<RoleScreen, Long> {
    List<RoleScreen> findByScreen(Screen screen);
    
    @Query( value = "SELECT * FROM role_screen rs where rs.role_id=:roleid AND rs.screen_id=:screenid" , nativeQuery = true)
    Optional<RoleScreen> findByRoleScreen(Long screenid, Integer roleid);
}
