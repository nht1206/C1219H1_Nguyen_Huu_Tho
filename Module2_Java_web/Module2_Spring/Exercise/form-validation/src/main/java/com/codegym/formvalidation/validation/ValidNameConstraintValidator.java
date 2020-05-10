package com.codegym.formvalidation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameConstraintValidator implements ConstraintValidator<ValidName, String> {
    ValidName constraintAnnotation;
    @Override
    public void initialize(ValidName constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null)
            return true;
        return s.length() >= 5 && s.length() <= 45;
    }
}
