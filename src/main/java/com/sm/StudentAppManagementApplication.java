package com.sm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Import(StudentAppConfig.class)
public class StudentAppManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAppManagementApplication.class, args);
	}

}
