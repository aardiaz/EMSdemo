package com.bway.springproject.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_tbl")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private int age;
	private int salary;
	private String companyName;
	private String post;
	private String department;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  dob;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joinDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_address_id" )
	private Address address;
	
	@ElementCollection
	@CollectionTable
	private Set<String> projectName;
	
	private String gender;
	
	
}
