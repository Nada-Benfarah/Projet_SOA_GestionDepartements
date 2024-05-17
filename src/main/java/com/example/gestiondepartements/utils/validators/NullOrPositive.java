package com.example.gestiondepartements.utils.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullOrPositiveValidator.class)
@Documented
public @interface NullOrPositive {
    String message() default "Field must be empty or have a positive value";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
