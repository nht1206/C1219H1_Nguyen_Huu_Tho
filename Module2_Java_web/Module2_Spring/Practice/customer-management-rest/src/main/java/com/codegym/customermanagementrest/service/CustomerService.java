package com.codegym.customermanagementrest.service;

import java.util.List;

import com.codegym.customermanagementrest.model.Customer;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(final Long id);
    void remove(final Customer customer);
    void remove(final Long id);
    void save(final Customer customer);
}