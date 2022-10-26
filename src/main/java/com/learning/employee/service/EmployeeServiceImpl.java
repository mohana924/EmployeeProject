package com.learning.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.employee.cosmos.repository.EmployeeCosmosRepository;
import com.learning.employee.entity.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeCosmosRepository repo;

	@Override
	public List<Employee> getAllEmployees() {
		Flux<Employee> flux = repo.findAll();
		return flux.collectList().block();
	}

	@Override
	public Mono<Employee> getEmployeeById(Long id) {
		Mono<Employee> emp = repo.findById(id);

		emp.subscribe(value -> System.out.println(value),
				error -> error.printStackTrace(),
				() -> System.out.println("Employee not found"));
		/*
		 * if (emp!=null) {
		 * employee = emp;
		 * } else {
		 * throw new RuntimeException(" Employee not found for id : " + id);
		 * }
		 */
		return emp;

	}

	@Override
	public void createEmployee(Employee employee) {
		repo.save(employee).subscribe();

	}

	@Override
	public Mono<Employee> updateEmployee(Long id, Employee employee) {

		return getEmployeeById(id)
				.map(e -> employee)
				.flatMap(repo::save)
				.switchIfEmpty(Mono.error(new RuntimeException("Employee with id " + id + " not found")));
	}

	@Override
	public Mono<Void> deleteEmployee(Long id) {
		return repo.deleteById(id);
	}

}
