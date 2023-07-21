package com.edstem.employeecrud.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LastNameValidator.class)
@Documented
public @interface ValidLastName {
    String message() default "LastName cant be empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
