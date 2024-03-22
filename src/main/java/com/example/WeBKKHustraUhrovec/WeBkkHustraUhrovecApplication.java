package com.example.WeBKKHustraUhrovec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableWebMvc
@CrossOrigin(origins = "http://localhost:4200")
public class WeBkkHustraUhrovecApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeBkkHustraUhrovecApplication.class, args);
	}

}
