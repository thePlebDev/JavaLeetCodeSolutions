package com.elliott.JavaLeetCodeSolutions.util.customValidators;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SizeTwoValidator implements ConstraintValidator<SizeTwo,String> {
    private String message;
    private int min;
    private int max;
    @Override
    public void initialize(SizeTwo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.message = message;
        this.min = min;
        this.max = max;

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        HibernateConstraintValidatorContext hibernateContext = context.unwrap(
                HibernateConstraintValidatorContext.class
        );
        hibernateContext.disableDefaultConstraintViolation();
        if(value == null){
            return true;
        }


        return true;
    }
}
