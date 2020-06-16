package com.codegym.finalexam.service;

import java.util.List;

import com.codegym.finalexam.dao.EmployeeGroupRepository;
import com.codegym.finalexam.model.EmployeeGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeGroupServiceImpl implements EmployeeGroupService {

    EmployeeGroupRepository employeeGroupRepository;

    /**
     * @param employeeGroupRepository the employeeGroupRepository to set
     */
    @Autowired
    public void setEmployeeGroupRepository(EmployeeGroupRepository employeeGroupRepository) {
        this.employeeGroupRepository = employeeGroupRepository;
    }

    @Override
    public List<EmployeeGroup> findAll() {
        return employeeGroupRepository.findAll();
    }
    
}