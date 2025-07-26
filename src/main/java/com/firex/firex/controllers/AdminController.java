package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Admin;
import com.firex.firex.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/admin")
public class AdminController implements RestControllerInterface<Admin> {

    @Autowired
    private AdminService adminService;

    @PostMapping
    @Override
    public Admin create(@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    @Override
    public Admin update() {
        return null;
    }

    @Override
    public Admin read() {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable long id) {

        adminService.delete(id);
        return Map.of("result", "Sucess");
    }
}

