package com.codegym.customermanager.repository;

import com.codegym.customermanager.model.Customer;
import com.codegym.customermanager.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
