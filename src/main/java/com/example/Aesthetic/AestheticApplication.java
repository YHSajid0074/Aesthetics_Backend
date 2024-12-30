package com.example.Aesthetic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AestheticApplication {

	public static void main(String[] args) {
		SpringApplication.run(AestheticApplication.class, args);
	}

}
