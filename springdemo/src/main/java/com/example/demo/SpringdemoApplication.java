package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringdemoApplication.class, args);
		System.out.println("Tomcat is still running.......");
	}

}
