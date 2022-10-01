package com.employee.employeeproject.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeproject.service.EmployeeService;
import com.employee.employeeproject.utility.Employee;

@RestController
public class EmployeeController {
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return getAllEmployees();
	}

	@GetMapping("/employee/delete/{id}")
	public void deleteEmployee(@PathVariable(value = "id") long id) {
		this.employeeService.deleteEmployeeById(id);
	}

	@PostMapping("/employee/save")
	public void saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
	}
}
