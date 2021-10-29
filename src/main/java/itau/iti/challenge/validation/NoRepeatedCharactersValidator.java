package itau.iti.challenge.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.stream.IntStream.range;

import itau.iti.challenge.validation.constraints.NoRepeatedCharacters;

public class NoRepeatedCharactersValidator implements ConstraintValidator<NoRepeatedCharacters, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return range(0, value.length())
            .noneMatch(i -> range(i + 1, value.length())
                .anyMatch(j -> value.charAt(i) == value.charAt(j)));
    }
}
