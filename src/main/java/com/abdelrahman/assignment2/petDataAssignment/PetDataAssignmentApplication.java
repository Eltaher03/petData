package com.abdelrahman.assignment2.petDataAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetDataAssignmentApplication {

	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path", "/pets/list");
		SpringApplication.run(PetDataAssignmentApplication.class, args);
	}

}
