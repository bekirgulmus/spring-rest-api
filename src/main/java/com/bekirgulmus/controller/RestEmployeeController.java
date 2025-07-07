package com.bekirgulmus.controller;

import com.bekirgulmus.model.Employee;
import com.bekirgulmus.model.UpdateEmployeeRequest;
import com.bekirgulmus.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

    private final EmployeeService employeeService;

    public RestEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(
            @PathVariable(name = "id", required = true )
            String id
    ) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeeWithParams(
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName
    ) {
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(
            @RequestBody Employee employee
    ){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(
            @PathVariable(name="id") String id
    ) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/update-employee/{id}")
    public Employee updateEmployee(
            @PathVariable(name = "id") String id,
            @RequestBody UpdateEmployeeRequest request
    ) {
        return employeeService.updateEmployee(id, request);
    }

}