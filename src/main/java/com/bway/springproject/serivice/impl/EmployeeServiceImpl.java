package com.bway.springproject.serivice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springproject.model.Employee;
import com.bway.springproject.rerpository.EmployeeRepository;
import com.bway.springproject.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository  employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		 
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		 
		return employeeRepository.getById(id);
	}

}
