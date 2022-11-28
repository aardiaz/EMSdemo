package com.bway.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "EMS",version = "2.5.0", description = "Employee Rest Api End Points"))
public class SpringprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

}
