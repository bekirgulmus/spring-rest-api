package com.bekirgulmus.repository;

import com.bekirgulmus.model.Employee;
import com.bekirgulmus.model.UpdateEmployeeRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public Employee getEmployeeById(String id) {
        Employee findEmployee = null;

        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeWithParams = new ArrayList<>();

        if (firstName == null && lastName == null) {
            return employeeList;
        }

        for (Employee employee : employeeList) {
            if (firstName != null && lastName != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }

            if (firstName != null && lastName == null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    employeeWithParams.add(employee);
                }
            }

            if (lastName != null && firstName == null) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }
        }

        return employeeWithParams;
    }

    public Employee saveEmployee(Employee employee) {
      employeeList.add(employee);
      return employee;
    }

    public boolean deleteEmployee(String id) {
        Employee deleteEmployee = null;

        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                deleteEmployee = employee;
                break;
            }
        }

        if (deleteEmployee != null) {
            employeeList.remove(deleteEmployee);
            return true;
        }

        return false;
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
        for(Employee employee : employeeList) {
            if(employee.getId().equals(id)) {
                employee.setFirstName(request.getFirstName());
                employee.setLastName(request.getLastName());
                return employee;
            }
        }

        return null;
    }
}
