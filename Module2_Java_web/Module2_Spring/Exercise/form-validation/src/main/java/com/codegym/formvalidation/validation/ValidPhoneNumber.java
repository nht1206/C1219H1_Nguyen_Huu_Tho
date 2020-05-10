package com.codegym.formvalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidPhoneNumberConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidPhoneNumber {
    String message() default "Phone number is invalid.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
