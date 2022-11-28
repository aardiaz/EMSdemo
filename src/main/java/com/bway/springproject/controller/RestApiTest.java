package com.bway.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestApiTest {
	
	
	@GetMapping("/restapi")
	public String getRestApiForm() {
		return "RestApiForm";
	}

}
