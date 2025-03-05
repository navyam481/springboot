package com.wipro.cloudserver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeService 
{

	@GetMapping("/getEmpList")
	public List<Employee> getEmpList()
	{
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(111,"Smith",34));
		emp.add(new Employee(222,"Scott",32));
		emp.add(new Employee(333,"James",28));
		emp.add(new Employee(444,"King",35));
		emp.add(new Employee(555,"Blake",27));
		emp.add(new Employee(666,"David",32));
		return emp;
	}
	
}
