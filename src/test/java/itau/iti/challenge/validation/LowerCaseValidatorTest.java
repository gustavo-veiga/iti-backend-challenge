package itau.iti.challenge.validation;

import static itau.iti.challenge.helper.AssertionsHelper.assertInvalid;
import static itau.iti.challenge.helper.AssertionsHelper.assertValid;

import itau.iti.challenge.validation.constraints.LowerCase;
import lombok.Value;
import org.junit.jupiter.api.Test;

class LowerCaseValidatorTest {
    @Test
    void hasLowerCaseInDummyName() {
        assertValid(new Dummy("Dummy"));
        assertValid(new Dummy("DummY"));
        assertValid(new Dummy("duMMy"));

    }

    @Test
    void noHasLowerCaseInDummyName() {
        assertInvalid(new Dummy("DUMMY"));
        assertInvalid(new Dummy("DUMMY_NAME"));
    }

    @Value
    private static class Dummy {
        @LowerCase
        String name;
    }
}
