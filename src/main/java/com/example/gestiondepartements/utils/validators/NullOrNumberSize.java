package com.example.gestiondepartements.utils.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullOrNumberSizeValidator.class)
@Documented
public @interface NullOrNumberSize {
    String message() default "Field must be empty or have a valid number size";

    String min() default "0";

    String max() default "1.7976931348623157E308";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
