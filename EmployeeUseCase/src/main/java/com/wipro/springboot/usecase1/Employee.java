package com.wipro.springboot.usecase1;

import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity
@Table(name="empUsecase")
public class Employee 
{
	@Id
	private String empId;
	
	private String name;
    private String role;
    
	public Employee() {
		super();
	}

	public Employee(String empId, String name, String role) {
		super();
		this.empId = empId;
		this.name = name;
		this.role = role;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
}
