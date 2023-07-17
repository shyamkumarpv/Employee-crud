package com.edstem.employeecrud.controller;


import com.edstem.employeecrud.contract.EmployeeResponse;
import com.edstem.employeecrud.model.Employee;
import com.edstem.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }


    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody Employee employee) {
        EmployeeResponse employeeResponse = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @PostMapping("/updateEmployeeById/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
        EmployeeResponse updatedEmployee = employeeService.updateEmployeeById(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }


    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee with ID " + id + " has been deleted.");

    }


}
