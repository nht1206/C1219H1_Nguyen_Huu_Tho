package com.codegym.finalexam.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentityCardValidator implements ConstraintValidator<IdentityCard, String> {

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        if (value == null)
            return true;
        return value.matches("^[0-9]{9}$");
    }
    
}