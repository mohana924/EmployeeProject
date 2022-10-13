package com.learning.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.azure.spring.data.cosmos.repository.config.EnableReactiveCosmosRepositories;

@SpringBootApplication
@EnableReactiveCosmosRepositories(basePackages = "com.employee.employeeproject.cosmos.repository")
public class EmployeeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectApplication.class, args);
	}

}
