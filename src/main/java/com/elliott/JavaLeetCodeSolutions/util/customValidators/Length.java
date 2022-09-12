package com.elliott.JavaLeetCodeSolutions.util.customValidators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated element must be greater than 0 and less than 30.
 * Accepts only Strings.
 */
@Target({FIELD,METHOD,PARAMETER,ANNOTATION_TYPE,TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = LengthValidator.class)
public @interface Length {

    String message() default "password is too short";

    int min() default 0;

    int max() default 30;

    Class<?>[] groups() default { }; //so apparently I need this

    Class<? extends Payload>[] payload() default { };
}
