package com.learning.employee.service;

import java.util.List;
import java.util.Optional;

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
	public Employee getEmployeeById(Long id) {
		Mono<Employee> emp = repo.findById(id);
		Employee employee = null;
		if (emp!=null) {
			employee = (emp);
		} else {
			throw new RuntimeException(" Employee not found for id : " + id);
		}
		return employee;

	}

	@Override
	public Employee createEmployee(Employee employee) {
		repo.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee updateEmployee = getEmployeeById(id);

		updateEmployee.setId(employee.getId());
		updateEmployee.setFirstName(employee.getFirstName());
		updateEmployee.setLastName(employee.getLastName());
		updateEmployee.setEmail(employee.getEmail());
		updateEmployee.setRole(employee.getRole());

		repo.save(updateEmployee);

		return updateEmployee;
	}

	@Override
	public void deleteEmployee(Long id) {
		this.repo.deleteById(id);

	}
	/* 
	 * @Override
	public List<Employee> getAllEmployees() {
		return null;
	}

	@Override
	public Employee getEmployeeById(Long id) {

		return null;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return null;
	}

	@Override
	public void deleteEmployeeById(long id) {
	}

	*/
	
}
