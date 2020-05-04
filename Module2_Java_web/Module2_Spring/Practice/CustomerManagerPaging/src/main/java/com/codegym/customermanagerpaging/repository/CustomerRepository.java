package com.codegym.customermanagerpaging.repository;

import com.codegym.customermanagerpaging.model.Customer;
import com.codegym.customermanagerpaging.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
    Optional<Customer> findById(Long id);
}
