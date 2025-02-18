package com.cts.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.cts.model" })
@EnableJpaRepositories(basePackages = { "com.cts.dao", "com.cts.service" })
@ComponentScan(basePackages = { "com.cts" })
@SpringBootApplication
public class SpringandspringbootallrequirementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringandspringbootallrequirementsApplication.class, args);
	}

}
