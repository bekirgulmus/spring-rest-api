package com.bekirgulmus.services;

import com.bekirgulmus.model.Employee;
import com.bekirgulmus.model.UpdateEmployeeRequest;
import com.bekirgulmus.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final List<Employee> employeeList;

    public EmployeeService(EmployeeRepository employeeRepository, List<Employee> employeeList) {
        this.employeeRepository = employeeRepository;
        this.employeeList = employeeList;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    public boolean deleteEmployee(String id) {
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
        return employeeRepository.updateEmployee(id, request);
    }
}