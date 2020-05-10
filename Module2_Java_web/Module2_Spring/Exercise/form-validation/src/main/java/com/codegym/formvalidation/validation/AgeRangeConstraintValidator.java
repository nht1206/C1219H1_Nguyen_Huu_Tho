package com.codegym.formvalidation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class AgeRangeConstraintValidator implements ConstraintValidator<AgeRange, Date> {
    private AgeRange annotation;
    @Override
    public void initialize(AgeRange constraintAnnotation) {
        annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        if (date == null)
            return true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return year >= annotation.min() && year <= annotation.max();
    }
}
