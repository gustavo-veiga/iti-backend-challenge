package itau.iti.challenge.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import itau.iti.challenge.validation.constraints.LowerCase;
import lombok.Value;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class LowerCaseValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void hasLowerCaseInDummyName() {
        var dummy = new Dummy("Dummy");
        assertTrue(validator.validate(dummy).isEmpty());
    }

    @Test
    void noHasLowerCaseInDummyName() {
        var dummy = new Dummy("DUMMY");
        assertFalse(validator.validate(dummy).isEmpty());
    }

    @Value
    private static class Dummy {
        @LowerCase
        String name;
    }
}
