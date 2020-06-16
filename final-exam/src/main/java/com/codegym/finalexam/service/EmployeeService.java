package com.codegym.finalexam.service;

import java.util.List;
import java.util.Optional;

import com.codegym.finalexam.model.Employee;

public interface EmployeeService {
    void save(Employee employee);
    void remove(String id);
    List<Employee> findAll();
    Optional<Employee> findById(String id);
}