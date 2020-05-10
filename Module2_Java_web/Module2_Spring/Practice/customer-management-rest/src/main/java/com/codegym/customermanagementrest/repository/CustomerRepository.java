package com.codegym.customermanagementrest.repository;

import com.codegym.customermanagementrest.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}