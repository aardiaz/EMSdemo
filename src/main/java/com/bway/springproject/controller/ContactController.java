package com.bway.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	
	
	@GetMapping("/contact")
	public String getEmailForm() {
		
		
		return "EmailForm";
	}
	
	@PostMapping("/contact")
	public String sendEmail(@RequestParam String toEmail,
							@RequestParam String subject,
							@RequestParam String message) {
		
		
		  
		
		return "EmailForm";
	}

}
