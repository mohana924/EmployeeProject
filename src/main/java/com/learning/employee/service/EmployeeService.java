package com.learning.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.employee.entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long id);

	public Employee createEmployee(Employee employee);

	public Employee updateEmployee(Long id, Employee employee);

	public void deleteEmployee(Long id);

}

	
	

