package com.rest.api.controller;

import com.rest.api.entities.Employee;
import com.rest.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Get All Employee Details
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployeeDetails() {
        List<Employee> employees = employeeService.getAllEmployeeDetails();
        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(employees);
    }

    //Get Single Employee Details
    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable("empId") int empId) {
        Employee employee = employeeService.getEmployeeById(empId);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(employee);
    }

    //Adding Employee Details in the database
    @PostMapping
    public ResponseEntity<Employee> addEmployeeDetails(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = this.employeeService.addEmployeeDetails(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Deleting Employee Details from the database
    @DeleteMapping("/{empId}")
    public ResponseEntity<Void> deleteEmployeeDetails(@PathVariable("empId") int empId) {
        try {
            this.employeeService.deleteEmployeeDetails(empId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Updating Employee Details in database
    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee,
                                                          @PathVariable("empId") int empId) {
        try {
            Employee updatedEmployee = this.employeeService.updateEmployeeDetails(employee, empId);
            return ResponseEntity.ok(updatedEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
