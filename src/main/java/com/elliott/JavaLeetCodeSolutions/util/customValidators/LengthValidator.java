package com.elliott.JavaLeetCodeSolutions.util.customValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidator implements ConstraintValidator<Length, String> {
    @Override
    public void initialize(Length constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }
        else if(value.length() <=8){
            return false;
        }
        return true;
    }
}
