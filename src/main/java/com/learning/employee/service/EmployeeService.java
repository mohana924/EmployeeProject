package com.learning.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.employee.entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long id);

	public Employee saveEmployee(Employee employee);

	public void deleteEmployeeById(long id);

}
