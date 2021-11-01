package itau.iti.challenge.validation;

import static itau.iti.challenge.helper.AssertionsHelper.assertInvalid;
import static itau.iti.challenge.helper.AssertionsHelper.assertValid;

import itau.iti.challenge.validation.constraints.UpperCase;
import lombok.Value;
import org.junit.jupiter.api.Test;

class UpperCaseValidatorTest {
    @Test
    void hasUpperCaseInDummyName() {
        assertValid(new Dummy("Dummy"));
        assertValid(new Dummy("DUMMY"));
    }

    @Test
    void noHasUpperCaseInDummyName() {
        assertInvalid(new Dummy("dummy"));
        assertInvalid(new Dummy("dummy_name"));

    }

    @Value
    private static class Dummy {
        @UpperCase
        String name;
    }
}
