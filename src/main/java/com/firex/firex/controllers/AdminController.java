package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Admin;
import com.firex.firex.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Admin delete() {
        return null;
    }
}
