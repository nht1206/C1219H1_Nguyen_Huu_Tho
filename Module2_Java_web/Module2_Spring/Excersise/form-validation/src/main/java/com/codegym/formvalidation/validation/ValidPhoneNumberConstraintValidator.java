package com.codegym.formvalidation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, String> {
   public void initialize(ValidPhoneNumber constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      if (obj == null)
         return true;
      return obj.matches("^$|[0-9]*$");
   }
}
