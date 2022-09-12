package com.elliott.JavaLeetCodeSolutions.util.customValidators;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidator implements ConstraintValidator<Length, String> {
    private String customMessage;
    private int customMin;
    private int customMax;

    @Override
    public void initialize(Length constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.customMessage = constraintAnnotation.message();
        this.customMax = constraintAnnotation.max();
        this.customMin = constraintAnnotation.min();
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
        else if(value.length() < customMin || value.length() > customMax){
            if (!customMessage.equals("password is too short")) {
                hibernateContext.addExpressionVariable("customMessage", customMessage)
                        .buildConstraintViolationWithTemplate("${customMessage}")
                        .enableExpressionLanguage()
                        .addConstraintViolation();
            }
            else {

                    hibernateContext
                            .addExpressionVariable("customMin", customMin)
                            .addExpressionVariable("customMax",customMax)
                            .buildConstraintViolationWithTemplate("Must be between ${customMin} and ${customMax}")
                            .enableExpressionLanguage()
                            .addConstraintViolation();

            }

            return false;


        }
        return true;
    }
}
