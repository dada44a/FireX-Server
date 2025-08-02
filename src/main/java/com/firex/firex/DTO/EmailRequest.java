package com.firex.firex.DTO;

import lombok.Getter;

public class EmailRequest {
    @Getter
    private String email;


    public void setEmail(String email) {
        this.email = email;
    }
}
