package com.edstem.employeecrud.controller;

<<<<<<< HEAD
import com.edstem.employeecrud.contract.EmployeeDto;
import com.edstem.employeecrud.service.EmployeeService;
import com.edstem.employeecrud.model.Employee;
import jakarta.validation.Valid;
=======

import com.edstem.employeecrud.contract.EmployeeResponse;
import com.edstem.employeecrud.model.Employee;
import com.edstem.employeecrud.service.EmployeeService;
>>>>>>> 00d3eb641b6d486478e3508b4d6c5dff75cbfb38
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
<<<<<<< HEAD
    public EmployeeController(EmployeeService  employeeService) {
=======
    public EmployeeController(EmployeeService employeeService) {
>>>>>>> 00d3eb641b6d486478e3508b4d6c5dff75cbfb38
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees()
                ,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee( @Valid @RequestBody EmployeeDto employee) {
        EmployeeDto employeeDto = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

<<<<<<< HEAD

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(
            @PathVariable int id, @Valid @RequestBody EmployeeDto employee) {
        EmployeeDto updatedEmployee = employeeService.updateEmployeeById(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee with ID " + id + " has been deleted.");
=======
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

>>>>>>> 00d3eb641b6d486478e3508b4d6c5dff75cbfb38
    }

}


}
