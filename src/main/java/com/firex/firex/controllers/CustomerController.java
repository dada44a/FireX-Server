package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Customer;
import com.firex.firex.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController implements RestControllerInterface<Customer> {

    @Autowired
    private CustomerService customerService;

    /**
     * Create a new customer
     * @param data Customer object from request body
     * @return The created Customer
     */
    @PostMapping
    @Override
    public Customer create(@RequestBody Customer data) {
        return customerService.create(data);
    }

    /**
     * Update an existing customer by ID
     * @param id Customer ID from the path
     * @param data Updated Customer data
     * @return The updated Customer
     */
    @PutMapping("/{id}")
    @Override
    public Customer update(@PathVariable long id, @RequestBody Customer data) {
        return customerService.update(id, data);
    }

    /**
     * Retrieve a customer by ID
     * @param id Customer ID from the path
     * @return Customer with given ID
     */
    @GetMapping("/{id}")
    @Override
    public Customer read(@PathVariable long id) {
        return customerService.read(id);
    }

    /**
     * Retrieve all customers
     * @return List of all customers
     */
    @GetMapping("/all")
    public List<Customer> readAll() {
        return customerService.readAll();
    }

    /**
     * Delete a customer by ID
     * @param id Customer ID from the path
     * @return A success message
     */
    @DeleteMapping("/{id}")
    @Override
    public Map<String, String> delete(@PathVariable long id) {
        return customerService.delete(id);
    }
}
