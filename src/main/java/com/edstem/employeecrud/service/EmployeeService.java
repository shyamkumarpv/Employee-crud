package com.edstem.employeecrud.service;

import com.edstem.employeecrud.contract.EmployeeRequest;
import com.edstem.employeecrud.contract.EmployeeDto;
import com.edstem.employeecrud.exception.EmployeeNotFoundException;
import com.edstem.employeecrud.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeRequest> employees = employeeRepository.findAll();
        return employees.stream().map(employeeRequest -> modelMapper.map(employeeRequest, EmployeeDto.class)).collect(Collectors.toList());
    }

    public EmployeeDto getEmployeeById(int id) {
        EmployeeRequest employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public EmployeeDto addEmployee(EmployeeRequest employee) {
        EmployeeRequest savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    public EmployeeDto updateEmployeeById(int id, EmployeeRequest employee) {
        EmployeeRequest existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        modelMapper.map(employee, existingEmployee);
        EmployeeRequest updatedEmployee = employeeRepository.save(existingEmployee);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    public void deleteEmployeeById(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }
}







