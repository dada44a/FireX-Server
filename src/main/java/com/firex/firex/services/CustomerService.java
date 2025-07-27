package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Admin;
import com.firex.firex.models.Customer;
import com.firex.firex.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService implements RestServiceInterface<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(Customer data) {
         return customerRepository.save(data);
    }


    @PutMapping("/{id}")
    @Override
    public Customer update(@PathVariable long id, @RequestBody Customer data) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Not Found"));

        Customer updatedCustomer =  customer
                .toBuilder()
                .email(data.getEmail())
                .name(data.getName())
                .phone(data.getPhone())
                .points(data.getPoints())
                .build();
        return customerRepository.save(updatedCustomer);
    }

    @Override
    public Customer read(long id) {

        return customerRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Customer Not Found"));
    }

    public List<Customer> readAll(){
        return customerRepository.findAll();
    }


    @Override
    public Map<String,String> delete(long id) {

        customerRepository.deleteById(id);
        return Map.of("result", "Sucess");
    }
}
