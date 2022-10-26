package com.learning.employee.service;

import java.util.List;

import com.learning.employee.entity.Employee;

import reactor.core.publisher.Mono;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Mono<Employee> getEmployeeById(Long id);

	public void createEmployee(Employee employee);

	public Mono<Employee> updateEmployee(Long id, Employee employee);

	Mono<Void> deleteEmployee(Long id);

}
