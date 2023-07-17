package com.edstem.employeecrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

        public EmployeeNotFoundException(int id ) {
            super("Could not find employee with id: " + id);
        }

}
