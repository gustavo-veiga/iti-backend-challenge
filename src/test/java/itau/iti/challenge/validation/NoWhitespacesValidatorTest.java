package itau.iti.challenge.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;

import itau.iti.challenge.validation.constraints.NoWhitespaces;
import lombok.Value;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class NoWhitespacesValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void hasWhitespaceInDummyName() {
        var dummy = new Dummy("Du mmy");
        assertFalse(validator.validate(dummy).isEmpty());
    }

    @Value
    private static class Dummy {
        @NoWhitespaces
        String name;
    }
}
