package com.example.EurekaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller 
{
	@GetMapping("/test")
	public String hello()
	{
		return "Hello Iam from EurekaService 2";
	}
}
