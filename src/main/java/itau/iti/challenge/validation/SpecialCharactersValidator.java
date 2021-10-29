package itau.iti.challenge.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Arrays.stream;

import itau.iti.challenge.validation.constraints.SpecialCharacters;

public class SpecialCharactersValidator implements ConstraintValidator<SpecialCharacters, String> {
    private String[] characters;

    @Override
    public void initialize(SpecialCharacters parameters) {
        characters = parameters.characters();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return stream(characters).anyMatch(value::contains);
    }
}
