package itau.iti.challenge.validation;

import static itau.iti.challenge.helper.AssertionsHelper.assertInvalid;
import static itau.iti.challenge.helper.AssertionsHelper.assertValid;

import itau.iti.challenge.validation.constraints.NoWhitespaces;
import lombok.Value;
import org.junit.jupiter.api.Test;

class NoWhitespacesValidatorTest {
    @Test
    void noHasWhitespaceInDummyName() {
        assertValid(new Dummy("Dummy"));
        assertValid(new Dummy("DUMMY"));
    }

    @Test
    void hasWhitespaceInDummyName() {
        assertInvalid(new Dummy("Du mmy"));
        assertInvalid(new Dummy("DU MMY"));

    }

    @Value
    private static class Dummy {
        @NoWhitespaces
        String name;
    }
}
