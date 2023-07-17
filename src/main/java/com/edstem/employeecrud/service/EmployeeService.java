package com.edstem.employeecrud.service;

import com.edstem.employeecrud.contract.EmployeeResponse;
import com.edstem.employeecrud.exception.EmployeeNotFoundException;
import com.edstem.employeecrud.model.*;
import com.edstem.employeecrud.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@Slf4j

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //private static List<Employee>employees=new ArrayList<>();
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        List<EmployeeResponse> responses = new ArrayList<>();
        for (Employee employee : employees)
            EmployeeResponse
                    .builder()
                    .id(employee.getId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .email(employee.getEmail())
                    .phone(employee.getPhone())
                    .position(employee.getPosition())
                    .department(employee.getDepartment())
                            .build();
    return responses;
}

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> {
            log.error("Emplyoee with id:{} not found", id);
            return new EmployeeNotFoundException(id);
        });
        return EmployeeResponse
                .builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .position(employee.getPosition())
                .department(employee.getDepartment())
                        .build();
    }
       public EmployeeResponse addEmployee(Employee employee){
        employee.setId(employee.getId());
        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employee.getLastName());
        employee.setEmail(employee.getEmail());
        employee.setPhone(employee.getPhone());
        employee.setPosition(employee.getPosition());
        employee.setDepartment(employee.getDepartment());

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .position(employee.getPosition())
                .department(employee.getDepartment())
                .build();

       }

    public EmployeeResponse updateEmployeeById(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> {
            log.error("Movie with id: {} not found", id);
            return new EmployeeNotFoundException(id);
        });
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setDepartment(employee.getDepartment());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .position(employee.getPosition())
                .department(employee.getDepartment())
                .build();
    }


        public void deleteEmployeeById(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }
    }








