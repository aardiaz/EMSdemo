package com.bway.springproject.api;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springproject.model.Employee;
import com.bway.springproject.model.Product;
import com.bway.springproject.service.IEmployeeService;

@RestController
public class EmployeeRestApi {
	
	@Autowired
	private IEmployeeService  service;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getAllEmployee() {
		
		return service.getAllEmployees();
	}

	@PostMapping("/api/emp/add")
	public String addEmp(@RequestBody Employee employee) {
		
		service.addEmployee(employee);
		return "added success";
	}

	@DeleteMapping("/api/emp/delete/{id}")
	public String deleteEmp(@PathVariable Long id) {
		
		service.deleteEmployee(id);
		return "delete success";
	}
	
	@PutMapping("/api/emp/update")
	public String updateEmp(@RequestBody Employee employee) {
		
		service.updateEmployee(employee);
		return "update success";
	}
	
	@GetMapping("/api/emp/{id}")
	public Employee getOne(@PathVariable Long id) {
		
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/api/emp/json2obj")
	public String jsonToObjectMapping() {
		
		RestTemplate  temp = new RestTemplate();
		Employee emp = temp.getForObject("http://localhost:8080/api/emp/3", Employee.class);
		
		return "FirstName = "+emp.getFirstName();
	}
	
	@GetMapping("/api/emp/jarray2objarray")
	public String jsonArrayToObjArrayMapping() {
		
		RestTemplate  temp = new RestTemplate();
		Employee[] employees = temp.getForObject("http://localhost:8080/api/emp/list", Employee[].class);
		
		
		return "FirstName : "+employees[1].getFirstName();
	}
	
	
	@GetMapping("/api/emp/products")
	public String jsonProductsMapping() {
		
		RestTemplate  temp = new RestTemplate();
		Product[] products = temp.getForObject("https://fakestoreapi.com/products", Product[].class);
		
		
		return "Title : "+products[0].getTitle();
	}
	
}
