package com.rest.api.service;

import com.rest.api.dao.EmployeeRepository;
import com.rest.api.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Get all Employee details
    public List<Employee> getAllEmployeeDetails() {
        return (List<Employee>) this.employeeRepository.findAll();
    }

    //Get Single Employee Details
    public Employee getEmployeeById(int empId) {
        Employee employee = this.employeeRepository.findById(empId);
        return employee;
    }

    //Add Employee Details in database
    public Employee addEmployeeDetails(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    //Delete Employee Details from database
    public void deleteEmployeeDetails(int empId) {
        this.employeeRepository.deleteById(empId);
    }

    //Update Employee Details in table
    public Employee updateEmployeeDetails(Employee employee, int empId) {
        employee.setEmpId(empId);
        return this.employeeRepository.save(employee);
    }
}
