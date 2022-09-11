package com.elliott.JavaLeetCodeSolutions.util.customValidators;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidator implements ConstraintValidator<Length, String> {
    private String customMessage;

    @Override
    public void initialize(Length constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.customMessage = constraintAnnotation.message();
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
        else if(value.length() <=8){
            hibernateContext.addExpressionVariable("customMessage", customMessage)
                    .buildConstraintViolationWithTemplate("${customMessage}")
                    .enableExpressionLanguage()
                    .addConstraintViolation();

            return false;
        }
        return true;
    }
}
