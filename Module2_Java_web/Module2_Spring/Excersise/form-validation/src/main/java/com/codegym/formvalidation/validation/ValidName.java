package com.codegym.formvalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidName {
    String message() default "The minimum length is 5 and maximum length is 45";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
