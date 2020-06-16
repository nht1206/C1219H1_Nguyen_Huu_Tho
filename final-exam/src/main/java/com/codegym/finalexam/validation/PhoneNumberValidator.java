package com.codegym.finalexam.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public void initialize(PhoneNumber annotation){
    }
    @Override
    public boolean isValid(String str, ConstraintValidatorContext cxt){
        if (str == null){
            return true;
        } else {
           return str.matches("((09|03|07|08|05)+([0-9]{8})\\b)");
        }
    }
}