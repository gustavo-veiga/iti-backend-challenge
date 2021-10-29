package itau.iti.challenge.validation;

import itau.iti.challenge.validation.constraints.UpperCase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpperCaseValidator implements ConstraintValidator<UpperCase, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.chars().anyMatch(Character::isUpperCase);
    }
}
