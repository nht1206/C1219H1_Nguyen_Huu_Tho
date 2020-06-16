package com.codegym.finalexam.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityCardValidator.class)
public @interface IdentityCard {
    String message() default "Your identify card number is not valid.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}