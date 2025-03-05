package com.wipro.empclient;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmpController 
{
	@Autowired
	@Lazy
	public RestTemplate restTemplate;
	
	@Value("${emp.service.url}")
	public String url;
	
	/*
	public String url="http://localhost:678/getEmpList";
	*
	*/
	@GetMapping("/getEmpList")
	public List getEmpList()
	{
		return restTemplate.getForObject(url,List.class);
	}
	
	@GetMapping("/msg")
	public String Message()
	{
		return "Iam from Employee Client3";
	}
	
	/**
	 * Creating object for predefined class using @Bean
	 */
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
