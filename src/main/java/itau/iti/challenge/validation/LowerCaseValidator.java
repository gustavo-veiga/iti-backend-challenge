package itau.iti.challenge.validation;

import itau.iti.challenge.validation.constraints.LowerCase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LowerCaseValidator implements ConstraintValidator<LowerCase, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.chars().anyMatch(Character::isLowerCase);
    }
}
