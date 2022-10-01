package com.employee.employeeproject.service;

import java.util.List;

import com.employee.employeeproject.utility.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long id);

	public void saveEmployee(Employee employee);

	public void deleteEmployeeById(long id);

}
