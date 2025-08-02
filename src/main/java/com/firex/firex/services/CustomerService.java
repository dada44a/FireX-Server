package com.firex.firex.services;

import com.firex.firex.models.Users;
import com.firex.firex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService{

    @Autowired
    private UserRepository customerRepository;


    public Users create(Users data) {
         return customerRepository.save(data);
    }




    public Users updateOrCreate(@RequestBody Users data) {
        Users existingUser = customerRepository.findByEmail(data.getEmail());

        if (existingUser != null) {
            // Update existing user
            Users updatedUser = existingUser.toBuilder()
                    .name(data.getName())
                    .phone(data.getPhone())
                    .points(data.getPoints())
                    .build();
            return customerRepository.save(updatedUser);
        } else {
            return customerRepository.save(data);
        }
    }

    public void updateRole(Long id, String data) {
        Users existingUser = customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        if (existingUser != null) {
            // Update existing user
            Users updatedUser = existingUser.toBuilder()
                    .name(existingUser.getName())
                    .phone(existingUser.getPhone())
                    .points(existingUser.getPoints())
                    .role(data)
                    .build();
            customerRepository.save(updatedUser);
        } else {
            System.out.println("HELLO WORLD");
        }
    }




    public Users read(long id) {

        return customerRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Customer Not Found"));
    }

    public Users readByEmail(String data) {

        return customerRepository
                .findByEmail(data);
    }

    public List<Users> readAll(){
        return customerRepository.findAll();
    }



    public Map<String,String> delete(long id) {

        customerRepository.deleteById(id);
        return Map.of("result", "Sucess");
    }
}
