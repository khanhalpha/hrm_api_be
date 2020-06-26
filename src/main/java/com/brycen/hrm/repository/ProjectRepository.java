package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brycen.hrm.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
