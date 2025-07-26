package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Customer;
import com.firex.firex.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class CustomerController implements RestControllerInterface<Customer> {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    @Override
    public Customer create(@RequestBody  Customer data) {
        return customerService.create(data);
    }

    @Override
    public Customer update() {
        return null;
    }

    @Override
    public Customer read() {
        return null;
    }

    @Override
    public Customer delete() {
        return null;
    }
}
