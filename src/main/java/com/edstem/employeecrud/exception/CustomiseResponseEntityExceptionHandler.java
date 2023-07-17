package com.edstem.employeecrud.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class CustomiseResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<com.edstem.employeecrud.exception.ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        com.edstem.employeecrud.exception.ErrorDetails errorDetails = new com.edstem.employeecrud.exception.ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<com.edstem.employeecrud.exception.ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<com.edstem.employeecrud.exception.ErrorDetails> handleEmployeeNotFoundException(Exception ex, WebRequest request) {
        com.edstem.employeecrud.exception.ErrorDetails errorDetails = new com.edstem.employeecrud.exception.ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<com.edstem.employeecrud.exception.ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object>handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        com.edstem.employeecrud.exception.ErrorDetails errorDetails = new com.edstem.employeecrud.exception.ErrorDetails(LocalDateTime.now(),
                "Total Errors: "+ ex.getErrorCount()+"First Error: "+ex.getFieldError().getDefaultMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);

    }
}

