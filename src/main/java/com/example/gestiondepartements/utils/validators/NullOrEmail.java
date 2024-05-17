package com.example.gestiondepartements.utils.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullOrEmailValidator.class)
@Documented
public @interface NullOrEmail {
    String message() default "Field must be empty or have a valid email address";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
