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

//@Repeatable(List.class) todo: find out what List.class does
@Target({FIELD,METHOD,PARAMETER,ANNOTATION_TYPE,TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = LengthValidator.class)
@Documented
public @interface Length {

    String message() default "message";

    int min() default 0;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
