package com.wipro.springboot.usecase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable String empId) {
        Employee employee = employeeService.getEmployeeById(empId);
        if (employee == null) {
            throw new RuntimeException("Employee with ID " + empId + " not found!");
        }
        return employee;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /*
    @PutMapping("/update/{empId}")
    public Employee updateEmployee(@PathVariable String empId, @RequestParam String role) {
        return employeeService.updateEmployee(empId, role);
    }
	*/
    
    @PutMapping("/update/{empId}")
    public ResponseEntity<?> updateEmployee(
        @PathVariable String empId,
        @RequestBody Map<String, String> requestBody) {  // Accept JSON body
        String role = requestBody.get("role");
        
        if (role == null || role.isEmpty()) {
            return ResponseEntity.badRequest().body("Role is required.");
        }
        return ResponseEntity.ok("Employee role updated successfully.");
    }

    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable String empId) {
        employeeService.deleteEmployee(empId);
        return "Employee with ID " + empId + " deleted successfully!";
    }
}
