package com.bekirgulmus.controller;

import com.bekirgulmus.model.Employee;
import com.bekirgulmus.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeeController {

    private final EmployeeService employeeService;

    public RestEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee-list")
    public List<Employee> getAllEmployeeList() {
        return employeeService.getAllEmployees();
    }
}