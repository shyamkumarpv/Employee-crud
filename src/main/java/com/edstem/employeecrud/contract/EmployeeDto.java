package com.edstem.employeecrud.contract;

import lombok.*;


@Builder
@Getter
@AllArgsConstructor
<<<<<<< HEAD:src/main/java/com/edstem/employeecrud/contract/EmployeeDto.java
public class EmployeeDto {
=======
public class EmployeeResponse {
>>>>>>> 00d3eb641b6d486478e3508b4d6c5dff75cbfb38:src/main/java/com/edstem/employeecrud/contract/EmployeeResponse.java
    private int id;
    private String firstName; // should not be empty
    private String lastName; // should not be empty
    private String email; // valid email
    private String phone; // should be 10 digits
    private String position;
    private String department;
}
