package com.esi.studentservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentRPLserviceApplication {

	public static void main(String[] args) {
		DatabaseInitializer.initialize("studentsrplservice_db");
		SpringApplication.run(StudentRPLserviceApplication.class, args);
	}
}
