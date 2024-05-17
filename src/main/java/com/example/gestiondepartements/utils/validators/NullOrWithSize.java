package com.example.gestiondepartements.utils.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullOrWithSizeValidator.class)
@Documented
public @interface NullOrWithSize {
    String message() default "Field must be empty or have a size between {min} and {max}";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

    int min() default 0;

    int max() default Integer.MAX_VALUE;
}
