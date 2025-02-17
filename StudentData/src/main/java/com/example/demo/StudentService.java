package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	public void addProduct(Student student) 
	{
		repo.save(student);
	}
}
