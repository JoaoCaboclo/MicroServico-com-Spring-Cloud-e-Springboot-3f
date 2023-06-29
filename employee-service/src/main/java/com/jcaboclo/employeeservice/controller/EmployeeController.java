package com.jcaboclo.employeeservice.controller;

import com.jcaboclo.employeeservice.model.Employee;
import com.jcaboclo.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Employee add: employee = {}",employee );
        return repository.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        LOGGER.info("Employee findBy: id = {}",id );
        return repository.findById(id);
    }
    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("Employee findAll");
        return repository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId = {}", departmentId);
        return repository.findByDepartment(departmentId);
     }

}
