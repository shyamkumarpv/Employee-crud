package com.edstem.employeecrud.contract;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private String department;
}
