package com.elliott.JavaLeetCodeSolutions.util.customValidators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * The annotated element must be greater than 1 and less than 88.
 * Accepts only strings
 *
 * **/

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = SizeTwoValidator.class)
public @interface SizeTwo {

    String message() default "password must be between 1 and 88";
    int min() default 1;
    int max() default 88;

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default{};


}
