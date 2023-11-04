package com.projects.PersonalityTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PersonalityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalityTestApplication.class, args);
	}

}