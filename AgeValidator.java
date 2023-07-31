package com.app.entity;

import java.time.LocalDate;
import java.time.Period;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeConstraint, LocalDate> {
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
        LocalDate date=LocalDate.now();
        int age=Period.between(dateOfBirth, date).getYears();
        if(age>=20||age<=15) {
        	return true;
        }else {
        return false;
        }
    }

	
}