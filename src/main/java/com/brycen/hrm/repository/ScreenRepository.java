package com.brycen.hrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brycen.hrm.model.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
    Optional<Screen> findByscreenURL(String screenURL);
}
