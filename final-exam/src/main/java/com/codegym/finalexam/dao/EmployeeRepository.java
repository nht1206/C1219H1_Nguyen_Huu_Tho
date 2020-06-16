package com.codegym.finalexam.dao;

import java.util.Date;
import java.util.List;

import com.codegym.finalexam.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByEmployeeCodeContainingAndIdCardNumberContaining(String employeeCode, String idCardNumber);
    List<Employee> findByEmployeeCodeContainingAndIdCardNumberContainingAndDateOfBirth(String employeeCode, String idCardNumber, Date dateOfBirth);
}