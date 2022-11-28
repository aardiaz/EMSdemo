package com.bway.springproject.service;

import java.util.List;

import com.bway.springproject.model.Employee;

public interface IEmployeeService {

	void addEmployee(Employee employee);

	void deleteEmployee(Long id);

	void updateEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);
}
