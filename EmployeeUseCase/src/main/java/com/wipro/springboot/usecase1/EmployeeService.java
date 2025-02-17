package com.wipro.springboot.usecase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Map<String, Employee> employeeCache = new HashMap<>();

    // Add Employee
    public Employee addEmployee(Employee employee) {
        employee.setRole(assignRole(employee.getRole())); // Validate role
        Employee savedEmployee = employeeRepository.save(employee);

        employeeCache.put(savedEmployee.getEmpId(), savedEmployee);
        return savedEmployee;
    }

    // Assign Role based on input (null-safe)
    private String assignRole(String role) {
        if (role == null) return "Unknown"; // Handle null case

        switch (role.trim().toLowerCase()) {
            case "developer":
                return "Developer";
            case "manager":
                return "Manager";
            case "tester":
                return "Tester";
            default:
                return "Unknown";
        }
    }

    // Get Employee by ID (with caching)
    public Employee getEmployeeById(String empId) {
        return employeeCache.computeIfAbsent(empId, id ->
                employeeRepository.findById(id).orElse(null));
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Update Employee Role
    public Employee updateEmployee(String empId, String newRole) {
        Employee employee = employeeRepository.findById(empId).orElse(null);
        if (employee == null) {
            throw new RuntimeException("Employee with ID " + empId + " not found!");
        }

        employee.setRole(assignRole(newRole));
        employeeRepository.save(employee);
        employeeCache.put(empId, employee);
        return employee;
    }

    // Delete Employee
    public void deleteEmployee(String empId) {
        if (!employeeRepository.existsById(empId)) {
            throw new RuntimeException("Employee with ID " + empId + " does not exist!");
        }

        employeeRepository.deleteById(empId);
        employeeCache.remove(empId);
    }
}
