package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StudentController 
{
	@Autowired
	StudentService service;

	@PostMapping("/student")
	public void addStudent(@RequestBody Student student)
	{
		service.addProduct(student);
	}
	
}
