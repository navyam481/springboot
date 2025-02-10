package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentDetails 
{

    private static final String template = "Student details are: ID: %d, Name: %s, Age: %d, Address: %s";
	private final AtomicLong atomicLong = new AtomicLong();
	
	
	@GetMapping("/student")
	public Student student(
			 @RequestParam(value = "id", defaultValue = "0") Integer id,
		        @RequestParam(value = "name", defaultValue = "No student data") String name,
		        @RequestParam(value = "age", defaultValue = "0") Integer age,
		        @RequestParam(value = "address", defaultValue = "Unknown") String address
		      ) 
	{
		return new Student((int) atomicLong.incrementAndGet(),name,age,address);
	}
}
