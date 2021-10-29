package itau.iti.challenge.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import itau.iti.challenge.validation.constraints.NoRepeatedCharacters;
import lombok.Value;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class NoRepeatedCharactersValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void hasRepeatedCharactersInDummyName() {
        var dummy = new Dummy("Dummy");
        assertFalse(validator.validate(dummy).isEmpty());
    }

    @Test
    void noHasRepeatedCharactersInDummyName() {
        var dummy = new Dummy("DuMy?");
        assertTrue(validator.validate(dummy).isEmpty());
    }

    @Value
    private static class Dummy {
        @NoRepeatedCharacters
        String name;
    }
}
