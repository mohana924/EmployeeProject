package com.employee.employeeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<com.employee.employeeproject.utility.Employee, Long> {

}
