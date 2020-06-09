package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brycen.hrm.model.LevelSkill;

public interface LevelRepository extends JpaRepository<LevelSkill, Long> {

}
