package com.firex.firex.services;

import com.firex.firex.models.Customer;
import com.firex.firex.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements RestServiceInterface<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(Customer data) {
         return customerRepository.save(data);
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
