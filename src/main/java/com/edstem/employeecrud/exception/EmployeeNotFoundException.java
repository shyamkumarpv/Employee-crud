package com.edstem.employeecrud.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int id) {
        super("Could not find employee with id: " + id);
    }

}
