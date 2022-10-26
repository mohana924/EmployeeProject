package com.learning.employee.cosmos.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.learning.employee.entity.Employee;

import reactor.core.publisher.Flux;

@Repository
public interface EmployeeCosmosRepository extends ReactiveCosmosRepository<Employee, Long> {

	Flux<Employee> findByFirstName(@Param("first_name") String first_name);
}
