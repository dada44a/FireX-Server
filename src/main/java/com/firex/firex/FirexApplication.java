package com.firex.firex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirexApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirexApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Welcome To FireX";
	}

}
