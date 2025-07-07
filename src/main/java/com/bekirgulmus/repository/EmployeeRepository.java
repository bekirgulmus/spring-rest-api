package com.bekirgulmus.repository;

import com.bekirgulmus.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employeeList;

    public EmployeeRepository(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getAllEmployeeList() {
        return employeeList;
    }
}
