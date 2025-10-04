package com.rest.api.dao;

import com.rest.api.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    public Employee findById(int id);
}
