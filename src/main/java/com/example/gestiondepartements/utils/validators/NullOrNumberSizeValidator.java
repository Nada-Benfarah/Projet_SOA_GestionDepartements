package com.example.gestiondepartements.utils.validators;

import java.lang.invoke.MethodHandles;

import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NullOrNumberSizeValidator implements ConstraintValidator<NullOrNumberSize, Number> {

    private static final Log log = LoggerFactory.make(MethodHandles.lookup());

    private String min;
    private String max;

    public void initialize(NullOrNumberSize parameters) {
        min = parameters.min();
        max = parameters.max();
        validateParameters();
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        double min = Double.parseDouble(this.min);
        double max = Double.parseDouble(this.max);

        return value.doubleValue() >= min && value.doubleValue() <= max;
    }

    private void validateParameters() {
        double min = Double.parseDouble(this.min);
        double max = Double.parseDouble(this.max);

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
