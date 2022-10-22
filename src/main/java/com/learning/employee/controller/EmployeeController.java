package com.learning.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.employee.entity.Employee;
import com.learning.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(@Autowired EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return this.employeeService.getEmployeeById(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
	}
	
	/*
	 @GetMapping("/")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return this.employeeService.getEmployeeById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable(value = "id") long id) {
		this.employeeService.deleteEmployeeById(id);
	}

	@PostMapping("/employee/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
	}
	 */
	
}
