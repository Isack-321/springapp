package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages="/demo/src/main/java/com/example/demo/appuser/userRepo.java")
@SpringBootApplication
public class UserRegApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegApplication.class, args);
	}

}
