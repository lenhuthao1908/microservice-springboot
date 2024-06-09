package com.microservices.validator.valid;


import com.microservices.validator.DobConstraintValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

public class DobValidator implements ConstraintValidator<DobConstraintValid, Date> {

    private int min;

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(date)) {
            return true;
        }

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();

        long years = ChronoUnit.YEARS.between(localDate, now);


        return years >= min;
    }

    @Override
    public void initialize(DobConstraintValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }
}
