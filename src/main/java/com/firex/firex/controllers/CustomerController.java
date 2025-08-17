package com.firex.firex.controllers;

import com.firex.firex.DTO.EmailRequest;
import com.firex.firex.models.Users;
import com.firex.firex.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Users")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Create a new customer
     *
     * @param data Customer object from request body
     * @return The created Customer
     */
    @PostMapping
    public Users create(@RequestBody Users data) {
        return customerService.create(data);
    }

    /**
     * Update an existing customer by ID
     *
     * @param data Updated Customer data
     * @return The updated Customer
     */
//    @PutMapping("/{id}")
//    public Users update(@PathVariable long id, @RequestBody Users data) {
//        return customerService.update(id, data);
//    }
    @PutMapping("/by_email")
    public Users updateByEmail(@RequestBody Users data) {
        return customerService.updateOrCreate(data);
    }

    /**
     * Retrieve a customer by ID
     *
     * @param id Customer ID from the path
     * @return Customer with given ID
     */
    @GetMapping("/{id}")
    public Users read(@PathVariable long id) {
        return customerService.read(id);
    }

    /**
     * Retrieve all customers
     *
     * @return List of all customers
     */
    @GetMapping("/all")
    public List<Users> readAll() {
        return customerService.readAll();
    }

    /**
     * Delete a customer by ID
     *
     * @param id Customer ID from the path
     */
    @DeleteMapping("/{id}")

    public void delete(@PathVariable long id) {
         customerService.delete(id);
    }

    @PostMapping("/by_email")
    public Users readByEmail(@RequestBody EmailRequest data) {
        return customerService.readByEmail(data.getEmail());
    }

    @PutMapping("/{id}/update_role")
    public void updateRole(@PathVariable long id, @RequestBody Map<String, String> payload) {
        String newRole = payload.get("role");
        customerService.updateRole(id, newRole);
    }
}


