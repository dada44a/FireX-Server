package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Admin;
import com.firex.firex.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController implements RestControllerInterface<Admin> {

    @Autowired
    private AdminService adminService;

    /**
     * Create a new admin
     * @param admin Admin data from the request body
     * @return The created Admin object
     */
    @PostMapping
    @Override
    public Admin create(@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    /**
     * Update an existing admin by ID
     * @param id Admin ID from the path
     * @param data Updated admin data from request body
     * @return The updated Admin object
     */
    @PutMapping("/{id}") // ✅ FIXED: @PathVariable must match the route
    @Override
    public Admin update(@PathVariable long id, @RequestBody Admin data) {
        return adminService.update(id, data);
    }

    /**
     * Retrieve an admin by ID
     * @param id Admin ID from the path
     * @return Admin object
     */
    @GetMapping("/{id}")
    @Override
    public Admin read(@PathVariable long id) {
        return adminService.read(id);
    }

    /**
     * Retrieve all admins
     * @return List of all Admins
     */
    @GetMapping("/all")
    public List<Admin> readAll() {
        return adminService.readAll();
    }

    /**
     * Delete an admin by ID
     * @param id Admin ID from the path
     * @return A success message
     */
    @DeleteMapping("/{id}")
    @Override
    public Map<String, String> delete(@PathVariable long id) {
        return adminService.delete(id);
    }
}
