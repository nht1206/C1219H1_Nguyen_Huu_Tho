package com.codegym.customermanagementrest.service;

import java.util.List;

import com.codegym.customermanagementrest.model.Customer;
import com.codegym.customermanagementrest.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    /**
     * @param customerRepository the customerRepository to set
     */
    @Autowired
    public void setCustomerRepository(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(final Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void remove(final Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void save(final Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(final Long id) {
        customerRepository.deleteById(id);
    }
    
}