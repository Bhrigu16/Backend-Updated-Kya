package com.backend.parivesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@SpringBootApplication(scanBasePackages={
//		"com.backend.parivesh", "com.example.model","com.example.controller","com.example.repository"})


@SpringBootApplication
@ComponentScan(basePackages = { "com.backend.*" })
@EntityScan("com.backend.*")
public class PariveshApplication {

	public static void main(String[] args) {
		SpringApplication.run(PariveshApplication.class, args);
	}

}
