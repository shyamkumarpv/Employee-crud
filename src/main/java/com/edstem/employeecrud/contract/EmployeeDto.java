package com.edstem.employeecrud.contract;

import com.edstem.employeecrud.validation.ValidEmail;
import com.edstem.employeecrud.validation.ValidFirstName;
import com.edstem.employeecrud.validation.ValidLastName;
import com.edstem.employeecrud.validation.ValidPhone;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private int id;

    @ValidFirstName private String firstName; // should not be empty
    @ValidLastName private String lastName; // should not be empty
    @ValidEmail private String email; // valid email
    @ValidPhone private String phone; // should be 10 digits
    private String position;
    private String department;
}
