package com.example.gestiondepartements.utils.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NullOrPositiveValidator implements ConstraintValidator<NullOrPositive, Number> {

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.doubleValue() > 0;
    }

}
