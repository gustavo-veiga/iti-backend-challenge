package itau.iti.challenge.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import itau.iti.challenge.validation.constraints.UpperCase;
import lombok.Value;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class UpperCaseValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void hasUpperCaseInDummyName() {
        var dummy = new Dummy("Dummy");
        assertTrue(validator.validate(dummy).isEmpty());
    }

    @Test
    void noHasUpperCaseInDummyName() {
        var dummy = new Dummy("dummy");
        assertFalse(validator.validate(dummy).isEmpty());
    }

    @Value
    private static class Dummy {
        @UpperCase
        String name;
    }
}
