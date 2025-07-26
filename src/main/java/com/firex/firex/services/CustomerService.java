package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Customer;
import com.firex.firex.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    public Map<String,String> delete(long id) {

        customerRepository.deleteById(id);
        return Map.of("result", "Sucess");
    }
}
