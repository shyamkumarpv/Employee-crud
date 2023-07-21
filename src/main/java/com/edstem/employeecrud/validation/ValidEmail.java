package com.edstem.employeecrud.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MailValidator.class)
public @interface ValidEmail {

    String message() default "Email provided is not valid ,should have 2 names separated by @";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
