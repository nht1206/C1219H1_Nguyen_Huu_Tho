package com.codegym.finalexam.dao;

import com.codegym.finalexam.model.EmployeeGroup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeGroupRepository extends JpaRepository<EmployeeGroup, Long> {
    
}