package com.codegym.customermanagementrest.controller;

import java.util.List;

import com.codegym.customermanagementrest.model.Customer;
import com.codegym.customermanagementrest.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    /**
     * @param customerService the customerService to set
     */
    @Autowired
    public void setCustomerService(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody final Customer customer) {
        customerService.save(customer);
        return customer;
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable final Long id) {
        return customerService.findById(id);
    }

    @PutMapping(value="/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        customerService.save(customer);
        return customer;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.remove(id);
    }
    
}