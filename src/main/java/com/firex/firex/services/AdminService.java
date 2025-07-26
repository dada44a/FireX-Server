package com.firex.firex.services;

import com.firex.firex.models.Admin;

import com.firex.firex.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements RestServiceInterface<Admin> {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin create(Admin data) {
        return adminRepository.save(data);
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
