package com.codegym.customermanager.service;

import com.codegym.customermanager.model.Customer;
import com.codegym.customermanager.model.Province;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
