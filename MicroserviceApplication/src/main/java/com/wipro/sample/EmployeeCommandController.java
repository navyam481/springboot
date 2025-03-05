package com.wipro.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
public class EmployeeCommandController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        service.createEmployee(employee);
        return "Employee created successfully!";
    }
}
