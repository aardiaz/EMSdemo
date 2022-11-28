package com.bway.springproject.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
