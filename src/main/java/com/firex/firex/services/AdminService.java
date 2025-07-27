package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Admin;

import com.firex.firex.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class AdminService implements RestServiceInterface<Admin> {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin create(Admin data) {
        return adminRepository.save(data);
    }

    @PutMapping("/{id}")
    @Override
    public Admin update(@PathVariable long id, @RequestBody Admin data) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Not Found"));
       Admin updatedAdmin =  admin.toBuilder()
               .email(data.getEmail())
               .name(data.getName())
               .phone(data.getPhone())
               .role(data.getRole())
               .build();
        return adminRepository.save(updatedAdmin);
    }

    @Override
    public Admin read(long id) {
        return adminRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Admin Not Found"));
    }

    public List<Admin> readAll(){
        return adminRepository.findAll();
    }



    @Override
    public Map<String,String> delete(long id) {

         adminRepository.deleteById(id);
         return Map.of("result", "Sucess");
    }
}
