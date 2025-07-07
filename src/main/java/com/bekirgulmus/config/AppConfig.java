package com.bekirgulmus.config;

import com.bekirgulmus.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","Bekir","Gülmüş"));
        employeeList.add(new Employee("2","Remzi","Kurçan"));
        employeeList.add(new Employee("3","Oğuz","Çidem"));
        employeeList.add(new Employee("4","İnan","Kaya"));
        employeeList.add(new Employee("5","Onur","Karabıyık"));

        return employeeList;
    }
}
