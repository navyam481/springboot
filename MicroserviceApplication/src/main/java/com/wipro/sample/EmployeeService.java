package com.wipro.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Command (Create Employee)
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Query (Retrieve all employees)
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}