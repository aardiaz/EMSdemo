package com.bway.springproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.model.Employee;
import com.bway.springproject.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/employee")
	public String showForm(HttpSession session) {
		
		  if(session.getAttribute("activeUser") == null)
			  return "LoginForm";
		
		return "EmployeeForm";
	}

	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute  Employee  employee) {
		
		service.addEmployee(employee);
		
		return "redirect:/employee";
	}
	
	@GetMapping("/list")
	public String getAll(Model model) {
		
		model.addAttribute("employeeList", service.getAllEmployees());
		
		return "EmployeeList";
	}
	
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam Long id) {
		
		service.deleteEmployee(id);
		
		return "redirect:/list";
	}
	
	@GetMapping("/edit")
	public String editEmp(@RequestParam Long id, Model model) {
		
		model.addAttribute("empModel", service.getEmployeeById(id));
		
		return "EmployeeEditForm";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee employee) {
		
		service.updateEmployee(employee);
		
		return "redirect:/list";
	}
	
}
