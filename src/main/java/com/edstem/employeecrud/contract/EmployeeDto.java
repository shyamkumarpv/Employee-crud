package com.edstem.employeecrud.contract;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private String department;
}
