package com.learning.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.learning.employee.cosmos.repository.EmployeeCosmosRepository;
import com.learning.employee.entity.Employee;

import reactor.core.publisher.Mono;

@SpringBootTest
public class AzureCosmosDbApplicationTest {

	@Autowired
	EmployeeCosmosRepository employeeCosmosRepository;

	@Test
	public void employeeCreated() {
		Employee employee = new Employee();
		employee.setId(100);
		employee.setFirstName("Dale");
		employee.setLastName("Steyn");
		employee.setEmail("dale.steyn@employee.com");
		employee.setRole("Bowler");

		employeeCosmosRepository.save(employee);
		Mono<Employee> retrievedEmployee = employeeCosmosRepository.findById(100L,
				new com.azure.cosmos.models.PartitionKey("/id"));

		retrievedEmployee.subscribe(value -> {
			System.out.println(value);
			Assert.notNull(value, "Retrieved Employee is present");
		}, error -> error.printStackTrace(), () -> System.out.println("completed without a value"));
	}

}
