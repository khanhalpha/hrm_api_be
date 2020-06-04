package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brycen.hrm.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
