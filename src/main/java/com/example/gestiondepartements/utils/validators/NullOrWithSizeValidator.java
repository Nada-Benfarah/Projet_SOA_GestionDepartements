package com.example.gestiondepartements.utils.validators;

import java.lang.invoke.MethodHandles;

import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NullOrWithSizeValidator implements ConstraintValidator<NullOrWithSize, String> {

    private static final Log log = LoggerFactory.make(MethodHandles.lookup());

    private int min;
    private int max;

    public void initialize(NullOrWithSize parameters) {
        min = parameters.min();
        max = parameters.max();
        validateParameters();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        int length = value.length();
        return length >= min && length <= max;
    }

    private void validateParameters() {
        if (min < 0) {
            throw log.getMinCannotBeNegativeException();
        }
        if (max < 0) {
            throw log.getMaxCannotBeNegativeException();
        }
        if (max < min) {
            throw log.getLengthCannotBeNegativeException();
        }
    }

}
