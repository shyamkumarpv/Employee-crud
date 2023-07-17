package com.edstem.employeecrud.contract;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
public class EmployeeResponse {
    private int id;
    private String firstName; // should not be empty
    private String lastName; // should not be empty
    private String email; // valid email
    private String phone; // should be 10 digits
    private String position;
    private String department;
}
