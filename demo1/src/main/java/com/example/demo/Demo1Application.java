package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) 
	{
		/*
		 * SpringApplication.run() is responsible to create the
		 * IOC container in JVM
		 */
		ConfigurableApplicationContext context = SpringApplication.run(Demo1Application.class, args);
		Message msg = context.getBean(Message.class);
		msg.printMessage();
	}

}
