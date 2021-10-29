package itau.iti.challenge.validation;

import itau.iti.challenge.validation.constraints.NoWhitespaces;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoWhitespacesValidator implements ConstraintValidator<NoWhitespaces, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.chars().noneMatch(Character::isWhitespace);
    }
}
