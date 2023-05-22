package com.esi.adviserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdviserserviceApplication {

	public static void main(String[] args) {
		DatabaseInitializer.initialize("adviserservice_db");
		SpringApplication.run(AdviserserviceApplication.class, args);
	}
}
