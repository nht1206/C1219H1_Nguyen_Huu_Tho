package com.codegym.finalexam.validation;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeRangeValidator implements ConstraintValidator<AgeRange, Date> {
    private AgeRange annotation;

    @Override
    public void initialize(AgeRange annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(Date field, ConstraintValidatorContext cxt) {
        if (field == null) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(field);
        int year = Calendar.getInstance().get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        return year >= annotation.min() && year <= annotation.max();
    }
}