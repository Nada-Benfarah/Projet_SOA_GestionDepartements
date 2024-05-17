package com.example.gestiondepartements.utils.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NullOrEmailValidator implements ConstraintValidator<NullOrEmail, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;
        return value.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

}
